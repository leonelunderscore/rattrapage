<?php
	try{
		$db = new PDO('mysql:host=localhost;dbname=rattrapage', 'root', '');
	}
	catch (Exception $e){
		die('Erreur : ' . $e->getMessage());
	}