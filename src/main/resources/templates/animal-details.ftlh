<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
  <title>Animal Details</title>

  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body>

  <!-- Begin Nav Bar -->
  <nav class="navbar navbar-expand-lg  navbar-dark" style="background-color: #1523e2ff;">
    <a class="navbar-brand" href="/animals" style="margin: 10px;">
      <img src="/logo.jpg" alt="" width="80" height="60">
    </a>
    <ul class="nav justify-content-end">
      <li class="nav-item">
        <a class="nav-link active" aria-current="page" href="/animals">Home</a>
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
    <div class="card">
      <h5 class="card-header">${animal.name}</h5>
      <img src="/profile-pictures/${(animal.profilePicturePath)!'avatar.png'}" class="card-img-top"
        style="height: 100px; width: 100px;" alt="profile picture">
      <div class="card-body">
        <span style="float:right"> <a href="/animals/updateForm/${animal.animalId?c}" class="btn btn-primary">Edit
            Animal</a></span>
        <h5 class="card-title">ID: ${animal.animalId?c}</h5>
        <p class="card-text">Email: ${animal.name}</p>
        <p class="card-text">Name: ${animal.age}</p>
        <p class="card-text">Description: ${animal.description}</p>
        <p class="card-text">Type: ${animal.animalType}</p>
        <a href="/animals/delete/${animal.animalId?c}" class="btn btn-danger">Delete
          Animal</a>

        <a href="/animals" class="btn btn-primary">Go back</a>
      </div>
    </div>

  </div>
</body>

</html>