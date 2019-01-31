var registerButtonOnClickHandler = function(threeDSecure){
	var creditCardNo = PF('register.creditCardNo').getValue().replace(new RegExp("\\D","g"),"");
	var expireDateMonth = PF('register.expireDate').getValue().substring(0,2);
	var expireDateYear = PF('register.expireDate').getValue().substring(3,5);
	var cvcNo = PF('register.cvcNo').getValue();
	var cardTokenCallback = function(cardToken){
		if(threeDSecure){
			registerCardThreeD([{name:"cardToken",value:cardToken}]);
		} else {
			registerCard([{name:"cardToken",value:cardToken}]);
		}
	}
	cardToken.getCardToken(
			creditCardNo,
			expireDateMonth,
			expireDateYear,
			cvcNo,
			cardTokenCallback);
}