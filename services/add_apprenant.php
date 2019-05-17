<?php 
	
	include_once 'config.php';

	$response['success']= 0 ;
	$response['message'] = 'erreur inconnue';

	if(!empty($_REQUEST['nomApprenant'])){
		$q = $db->prepare("INSERT INTO apprenants(nomApprenant) VALUES(?)");
		if ($q->exexute([$_REQUEST['nomApprenant']])) {
			$response['success']= 1 ;
			$response['message'] = 'inscrtiption réussie';
		}
	}

	echo json_encode($response);


 ?>