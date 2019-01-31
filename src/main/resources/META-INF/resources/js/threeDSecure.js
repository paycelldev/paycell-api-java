var openThreeDSecurePage = function(threeDSessionId, callbackUrl) {
	window.threeDSecurePage.location = window.location.origin+`/threeDSecurePage.jsf?threeDSessionId=${threeDSessionId}&callbackUrl=${callbackUrl}`;
}

var closeThreeDSecurePage = function() {
	window.threeDSecurePage.close();
}