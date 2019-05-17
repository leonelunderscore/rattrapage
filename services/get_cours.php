<?php 
	include_once 'Cours.php';


	$response['success'] = 0;
    $response['message'] = '';
    $response['datas'] = [];


	$cours = Cours::getCours();
	
	if (count($cours) > 0) {
		$response['success'] = 1;
		$response['message']= 'Requête éffectuée';
		$i = 0;
		foreach ($cours as $cour) {
			if ($cour instanceof Cours ) {
				$response['datas'][$i] = [
					'id' => $cour->id,
					'description' => $cour->description,
					'prix' => intval($cour->prix),
					'type' => $cour->type,
					'niveau' => $cour->niveau,
					'nom' => $cour->nom,
				];
				$i++;
			}
		}

	}else{
		$response['message']= 'Pas de cours';
	}

	

	echo json_encode($response);
