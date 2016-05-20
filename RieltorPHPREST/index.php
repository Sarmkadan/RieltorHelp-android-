<?php
  // прототип REST без использования сторонних бибилиотек
  print_r ($_SERVER);
  echo "<br>";
  // о
  if ($_SERVER['REQUEST_METHOD']=='GET') {
    echo "YEST GET<br>";
    echo "QUERY_STRING :".$_SERVER['QUERY_STRING'];
    // вот так можно обработать переданный url
    // или же что более правильно можно тестировать регуляркой
    if ($_SERVER['QUERY_STRING']=='url=/') {
     echo "<br>ROOT !!!!!<br>";
    }else {
     echo "<br>RestData</br>";
    }
  }
  
  if ($_SERVER['REQUEST_METHOD']=='POST') {
    echo "--------------------------<br>";
    print_r ($_POST);
    
  }
  
  if ($_SERVER['REQUEST_METHOD']=='PUT') {
   $_PUT =array();
   $putdata =file_get_contents('php://input');
   $exploded=explode('&',$putdata);
   foreach ($exploded as $pair) {
    $item = explode('=',$pair);
    if (count($item)==2){
      $_PUT[urldecode($item[0])]=urldecode($item[1]);
    }
   }
   print_r ($_PUT);
  }
  if ($_SERVER['REQUEST_METHOD']=='DELETE') {
  
  }
?>