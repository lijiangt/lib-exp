<?php
//sudo apt-get install php5-mcrypt
ini_set("soap.wsdl_cache_enabled", "0");  
require('soap-wsse.php');

class mySoap extends SoapClient {

   function __doRequest($request, $location, $saction, $version) {
    $doc = new DOMDocument('1.0');
    $doc->loadXML($request);

    $objWSSE = new WSSESoap($doc);

    $objWSSE->addUserToken("1111", "optimuspasswd", TRUE);
    $objWSSE->addTimestamp(300);

    return parent::__doRequest($objWSSE->saveXML(), $location, $saction, $version);
   }
}


$wsdl = "http://localhost:8080/testCXF/service/HelloWorld?wsdl";

$soapclient = new mySoap($wsdl, array('trace'=>1));

try {
var_dump ( $soapclient->__getFunctions () );//获取服务器上提供的方法

echo "<br />";

var_dump ( $soapclient->__getTypes () );//获取服务器上数据类型
echo "<br />";
$res = $soapclient->sayHello(array('arg0'=>"Silver Lee",'arg1'=>array('test'=>'tteesstt','desc'=>'ddeesscc','priority'=>5)));
print_r($res->return->result);
print_r($res->return->desc);
echo "<br />";
$res = $soapclient->sayHi(array('arg0'=>"Silver Lee"));
print_r($res->return->result);
print_r($res->return->desc);
//    var_dump($res);
} catch (SoapFault $fault) {
    print("Fault string: " . $fault->faultstring . "\n");
    print("Fault code: " . $fault->detail->WebServiceException->code . "\n");
}

echo $sClient->__getLastRequest() .
    "\n" .
    $sClient->__getLastResponse();
?>



