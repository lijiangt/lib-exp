<?php
require('soap-wsse.php');

class mySoap extends SoapClient {

   function __doRequest($request, $location, $saction, $version) {
    $doc = new DOMDocument('1.0');
    $doc->loadXML($request);

    $objWSSE = new WSSESoap($doc);

    $objWSSE->addUserToken("YOUR_USERNAME_HERE", "YOUR_PASSWORD_HERE", TRUE);

    return parent::__doRequest($objWSSE->saveXML(), $location, $saction, $version);
   }
}


$wsdl = 'https://devauth.utcc.utoronto.ca/wsbuild/services/1_0_0/PersonService?wsdl';

$sClient = new mySoap($wsdl, array('trace'=>1));
$wrapper->credentials->personId = new SoapVar("9300002", XSD_STRING);
try {
    $result = $sClient->getEmail($wrapper);
    print_r($result->return);
} catch (SoapFault $fault) {
    print("Fault string: " . $fault->faultstring . "\n");
    print("Fault code: " . $fault->detail->WebServiceException->code . "\n");
}

echo $sClient->__getLastRequest() .
    "\n" .
    $sClient->__getLastResponse();
?>
