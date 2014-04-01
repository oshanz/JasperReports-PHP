<?php
/**
 * @author Waruna Oshan Wisumperuma
 * @contact warunaoshan@gmail.com
 */
$args='{aS:SD,a:1}';
$shell_exec=shell_exec("java -jar '/home/trisquel/NetBeansProjects/online_print/dist/online_print.jar' ".$args);
print_r($shell_exec);
