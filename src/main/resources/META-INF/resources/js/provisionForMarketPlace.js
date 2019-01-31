var sendProvisionForMarketPlaceHandler = function(threeDSecure, preferRegisteredCard) {
	var creditCardNo;
	var expireDateMonth;
	var expireDateYear;
	var cvcNo;
	var cardTokenCallback = function(cardToken) {
		if (threeDSecure) {
			sendProvisionForMarketPlaceThreeD([ {
				name : "cardToken",
				value : cardToken
			} ]);
		} else {
			sendProvisionForMarketPlace([ {
				name : "cardToken",
				value : cardToken
			} ]);
		}
	}

	if (preferRegisteredCard) {
		cvcNo = PF('provisionForMarketPlace.cvc').getValue();

		if (cvcNo) {
			cardToken.getCardToken(creditCardNo, expireDateMonth,
					expireDateYear, cvcNo, cardTokenCallback);
		} else {
			cardTokenCallback(null);
		}
	} else {
		creditCardNo = PF('custom.creditCardNo').getValue().replace(
				new RegExp("\\D", "g"), "");
		expireDateMonth = PF('custom.expireDate').getValue().substring(0, 2);
		expireDateYear = PF('custom.expireDate').getValue().substring(3, 5);
		cvcNo = PF('custom.cvcNo').getValue();

		cardToken.getCardToken(creditCardNo, expireDateMonth, expireDateYear,
				cvcNo, cardTokenCallback);
	}
}