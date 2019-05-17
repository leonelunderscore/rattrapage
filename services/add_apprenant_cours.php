<?php 
	include_once 'Cours.php';


	$response['success'] = 0;
    $response['message'] = '';

    if (!empty($_REQUEST['apprenant_id']) && !empty($_REQUEST['cours_id'])) {
    	extract($_REQUEST);
    	if (Cours::checkCours($cours_id,$apprenant_id) == false) {
    		$dateDebut = '2019-05-17';
    		$dateFin = '2019-12-17';
    		Cours::addApprenantCours($cours_id,$apprenant_id,$dateDebut,$dateFin);
    		$response['success'] = 1;
    		$response['message'] = 'Inscription éffectuée!';
    	}else{
    		$response['success'] = 2;
    		$response['message'] = 'Vous êtes déjà inscrit à ce cours';
    	}
    }else{
    	$response['message']= 'Données insufisantes';
    }
	echo json_encode($response);

