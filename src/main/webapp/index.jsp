<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <title>Stock Management </title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="p-4">
<h1>Ajouter Des Produits</h1>
<form class="p-4" action="insert" method="post">
    <div class="form-group">
        <label for="nome">Nom du produit</label>
        <input type="text" class="form-control" id="nome" aria-describedby="emailHelp" name="name" placeholder="Enter Nom du produit" >
    </div>
    <div class="form-group">
        <label for="desc">Description</label>
        <input type="text" class="form-control" name="description" id="desc" placeholder="Description" >
    </div>


   <div class="form-group">
    <label for="stock">Quantité en stock</label>
    <input type="number" class="form-control" id="stock" name="quantity" placeholder="Quantité en stock"
           required>
</div>

<div class="form-group">
    <label for="prix">Prix unitaire</label>
    <input type="number" class="form-control" id="prix" name="price" placeholder="Prix unitaire"
           required>
</div>


    <div class="form-group col-md-4">
        <label for="inputCat">Catégorie du produit</label>
        <select id="inputCat" name="category" class="form-control" >
            <option selected disabled>Choose...</option>
            <option>Electronique</option>
            <option>Vetements</option>
            <option>Alimentation</option>

        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<h1>List  Des Produits</h1>

<table class=" table">
    <thead  class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name of the product</th>
        <th scope="col">Quantité</th>
        <th scope="col">Prix</th>
        <th scope="col"></th>

    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td>Frommage</td>
        <td>12ps</td>
        <td>140dh</td>
        <td><button class="btn btn-danger btn-sm">Delete</button>
            <button class="btn btn-info btn-sm">Update</button></td>
    </tr>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>