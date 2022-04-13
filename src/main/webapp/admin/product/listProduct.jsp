<%@ page import="java.util.List" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.example.thijava.entity.Product" %>
<%
    List<Product> list= (List<Product>) request.getAttribute("productList");
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<a href="/shopping-cart/show">Cart</a>
<table class="table">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Amount</th>
        <th>detail</th>
        <th>Action</th>
    </tr>
    <% for (Product p :list){
    %>
    <tr>
        <th><%=p.getId()%></th>
        <th><%=p.getName()%></th>

        <th><%=p.getPrice()%></th>
        <th><%=p.getAmount()%></th>
        <th><%=p.getDetails()%></th>
        <th>
            <a href="/shopping-cart/add?productId=<%=p.getId()%>&quantity=1">Add to cart</a>
            <a href="/product/detail?id=<%=p.getId()%>">Detail</a>
            <a href="/product/edit?id=<%=p.getId()%>">Edit</a>
            <a href="/product/delete?id=<%=p.getId()%>" class="btn-delete">Delete</a>
        </th>
    </tr>
    <%}%>
</table>

<script>
    document.addEventListener('DOMContentLoaded',function (){
        let listDeleteButton = document.querySelectorAll('.btn-delete');
        for (let i =0 ; i<listDeleteButton.length;i++){
            listDeleteButton[i].addEventListener('click',function (event){
                event.preventDefault();
                if (confirm("are you sure ?")){
                    // alert(this.href)
                    let xhr = new XMLHttpRequest();
                    xhr.onreadystatechange = function (){
                        if (xhr.readyState==4 && xhr.status==200){
                            alert('Delete suc')
                            window.location.href="/product/list"
                        }
                    }
                    xhr.open('POST',this.href,false)
                    xhr.send();
                }
            })
        }
    })
</script>
</body>
</html>