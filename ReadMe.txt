přehled (GET):
http://localhost:8080/services/HomeWork/L08/products

přehled (GET):
http://localhost:8080/services/HomeWork/L08/productOne/valueId

různé typy přehledů:
http://localhost:8080/services/HomeWork/L08/productsList/valueList
valueList - produkty seřazené podle ceny



insert (POST):
http://localhost:8080/services/HomeWork/L08/product
{"name":"Rádio", "price":121 }
{"name":"Televize Tesla", "price":2222.45}
{"name":"Televize Samsung", "price":1111.12}

delete (DELETE):
http://localhost:8080/services/HomeWork/L08/product/1


update (PUT):
http://localhost:8080/services/HomeWork/L08/product/1
{"name":"Rádio", "price":"121 Kč"}
