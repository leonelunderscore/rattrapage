<?php 
	include_once 'Cours.php';


	$response['success'] = 0;
    $response['message'] = '';
    $response['datas'] = [];

    if (!empty($_REQUEST['apprenant_id'])) {
    	extract($_REQUEST);
    	$cours = Cours::getApprenantCours($apprenant_id);

    	if (count($cours) > 0) {
			$response['message']= 'Requête éffectuée';
			$i = 0;
			foreach ($cours as $cour) {
				if ($cour instanceof Cours ) {
					$response['datas'][$i] = [
						'id' => $cour->id,
						'nom' => $cour->nom,
						'description' => $cour->description,
						'prix' => $cour->prix,
						'type' => $cour->type,
						'niveau' => $cour->niveau,
					];
					$i++;
				}
			}

		}else{
			$response['message']= 'Pas de cours';
		}
    }else{
    	$response['message']= 'Pas d\'apprenant spécifié';
    }
	echo json_encode($response);

