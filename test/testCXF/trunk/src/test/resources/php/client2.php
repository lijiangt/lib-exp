<?php
//参考： http://www.cnblogs.com/bugY/archive/2011/10/09/2203627.html
//参考： http://fengfan2008.iteye.com/blog/509342
// http://www.sis.utoronto.ca/web_services/code_samples.html
// http://code.google.com/r/zen35111-wse/source/browse/soap-wsse.php?r=917fa3577b6d05c2c5e1d05f7695b66750fd8dd8
// http://code.google.com/r/zen35111-wse/
// http://code.google.com/p/wse-php/source/clones
// http://www.cdatazone.org/files/soap-wsa-example.phps
// http://www.cdatazone.org/index.php?/categories/1-PHP
ini_set("soap.wsdl_cache_enabled", "0");  
//require_once 'SOAP/Client.php';
//$wsdl = new SOAP_WSDL("http://localhost:8080/test-cxf/service/HelloWorld?wsdl");
//$soapclient = $wsdl->getProxy();  
$soapclient = new SoapClient("http://localhost:8080/test-cxf/service/HelloWorld?wsdl", array('encoding'=>'UTF-8')); 

var_dump ( $soapclient->__getFunctions () );//获取服务器上提供的方法

echo "<br />";

var_dump ( $soapclient->__getTypes () );//获取服务器上数据类型
echo "<br />";
$result=$soapclient->sayHi(array('arg0'=>'World'));
print_r($result);
echo "<br />";
$result=$soapclient->sayHello(array('arg0'=>"World",'arg1'=>3,'arg2'=>TRUE));

//$result=$client->sayHello("World",3,TRUE);
//echo $result->return; 
print_r($result);

?>
