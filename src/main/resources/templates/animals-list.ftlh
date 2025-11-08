<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Animal List</title>

    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body>

<!-- Begin Nav Bar -->
<nav class="navbar navbar-expand-lg  navbar-dark" style="background-color: #1a2edcff;">
    <a class="navbar-brand" href="/animals" style="margin: 10px;">
        <img src="/logo.jpg" alt="" width="80" height="60">
    </a>
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/animals" >Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Second</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Third</a>
        </li>
    </ul>
</nav>
<!-- End Nav Bar -->

<div class="container" style="margin-top: 15px;">
    <h1>${title}</h1>
    <a href="/animals/createForm" class="btn btn-outline-primary" style="float:right;">Create New Animal</a>

    <form action="/animals/name">
        <input type="text" name="name" placeholder="Search By Name &#128270;">
    </form>

    <!-- Animals Table -->
    <table class="table table-striped rounded-3 overflow-hidden">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>
        </tr>
        <#list animalsList as animal>
        <tr>
            <td>
                <a href="/animals/${animal.animalId?c}" style="color:#000000">${animal.animalId?c}</a>
            </td>
            <td>${animal.name}</td>
            <td>
                <a href="/animals/type/${animal.animalType}" style="color:#000000">${animal.animalType}</a>
            </td>
        </tr>
        </#list>
    </table>

</div>
</body>
</html>