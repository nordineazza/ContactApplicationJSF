function supprimerContact(e) {
	e.preventDefault()
	swal({
		title : "Supprimer ce contact?",
		text : "Vous ne pourrez plus le récupérer.",
		type : "warning",
		showCancelButton : true,
		confirmButtonColor : "#DD6B55",
		confirmButtonText : "Oui",
		cancelButtonText : "Annuler",
		closeOnConfirm : false
	}, function(isConfirm) {
		alert(isConfirm);
		if(isConfirm) return true;
		return false;
	});

}
