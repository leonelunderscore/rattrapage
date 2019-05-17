<?php 
	include_once 'config.php';
	class Cours{
		public $id;
		public $nom;
		public $description;
		public $prix;
		public $type;
		public $niveau;
		public function __construct($id,$nom,$desc,$prix,$type,$niveau){
			$this->id = $id;
			$this->nom = $nom;
			$this->description = $desc;
			$this->prix = $prix;
			$this->type = $type;
			$this->niveau = $niveau;
		}

		public static function getCours(){
			$results = [];
			global $db;
			$q = $db->query("SELECT c.*, n.intitule,t.nomType FROM cours AS c, niveaux_cours AS n, types_cours AS t WHERE c.id_type = t.id_type AND c.id_niveau = n.id_Niveau");
			$cours = $q->fetchAll(PDO::FETCH_OBJ);

			foreach ($cours as $cour) {
				$results[] = new Cours($cour->id_lesson,$cour->nomLesson,$cour->description,$cour->prix,$cour->nomType,$cour->intitule);
			}

			return $results;
		}

		public static function getApprenantCours($id){
			global $db;
			$results = [];
			$cours = self::getCours();

			foreach ($cours as $cour) {
				if (self::checkCours($cour->id,$id)) {
					$results[] = $cour;
				}
			}
			return $results;
		}


		public static function checkCours($idCours,$idApprenant){
			global $db;
			$q = $db->prepare("SELECT * FROM apprenants_cours WHERE lessonId = ? AND apprenantId = ?");
			$q->execute([$idCours,$idApprenant]);
			if ($q->fetch()) {
				return true;
			}
			return false;
		}

		public static function addApprenantCours($idCours,$idApprenant,$dateDebut,$dateFin){
			global $db;
			if (self::checkCours($idCours,$idApprenant) == false) {
				try
				{
					$q = $db->prepare("INSERT INTO apprenants_cours(dateInsctiption,dateFin,lessonId,apprenantId) VALUES(?,?,?,?)");
					$q->execute([$dateDebut,$dateFin,$idCours,$idApprenant]);
				}catch(Exception $e){}
			}
		}
	}



 ?>