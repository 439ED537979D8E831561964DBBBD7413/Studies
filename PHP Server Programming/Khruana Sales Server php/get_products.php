<?php
 
/*
 * Following code will list all the products
 */
 $response = array();
$response1=array();
$conn = mysqli_connect("localhost", "KhuranaSales", "9270481042khurana") or die(mysqli_error());
$db = mysqli_select_db($conn, "KhuranaSalesRastapeth");
$product = array();
$brand = isset($_GET['brand']) && $_GET['brand'] != '' ? $_GET['brand'] : "no";
$type = isset($_GET['type']) && $_GET['type'] != '' ? $_GET['type'] : "Mobile";
if($type == "Mobile")
{
$query = "SELECT * FROM khurana_sales_stock where Brand = '".$brand."' And Stock > 0  AND Name LIKE '%Mobile%'";
}
else
{
$query = "SELECT * FROM khurana_sales_stock where Brand = '".$brand."' And Stock > 0  AND Name NOT LIKE '%Mobile%' AND Name NOT LIKE '%Tab%'";

}

$result = mysqli_query($conn, $query) or die(mysqli_error());
if (mysqli_num_rows($result)>0) {
    while ($row = mysqli_fetch_array($result)) {
        $product2["product_id"] = $row["product_id"];
        $product2["Name"] = $row["Name"];
        $product2["stock"] = $row["Stock"];
        $product2["mrp"] = $row["Price_MRP"];
        $product2["mop"] = $row["Price_MOP"];
        $product2["ksprice"] = $row["Price_KS"];
        $product2["link"] = $row["links"];
        $product2["tax"] = $row["product_tax_percent"];
        array_push($response1,$product2);

          }

echo json_encode($response1);


}
else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No products found";
 
    // echo no users JSON
    echo json_encode($response);
}
?>


