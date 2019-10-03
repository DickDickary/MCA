<!DOCTYPE html>
<html lang="en">
<head>
    <h1>MyCaAm</h1><title>MyCaAm</title>
</head>
<body>
<div class="card-group">

</div>
<div>
    <#list carForms as cars>
        <div class="card">
            <#if cars.carPic??>
                <img src="/img/${cars.carPic}" class="card-img-top">
            </#if>
            <div class="card-body">
                <h5 class="card-title">${cars.carName}</h5>
                <p class="card-text">${cars.text}</p>
                <p class="card-text">
                    <small class="text-muted">${cars.data}</small>
                </p>
            </div>
        </div>
    </#list>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Add new users
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">

                <div class="form-group">
                    <input type="text" class="form-control" name="carName" placeholder="Введите марку">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="text" placeholder="Введите описание">
                </div>

                <div class="form-group mt-3">
                    <label>
                        <input class="custom-file" type="number" name="carCost" placeholder="Введите стоимость">
                    </label>
                </div>
                <div class="custom-file">
                    <input type="file" name="file" id="customFIle">
                    <label class="custom-file-label" for="customFIle">Choose file</label>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Внести</button>
                </div>
            </form>
        </div>
    </div>

</div>

</body>
</html>