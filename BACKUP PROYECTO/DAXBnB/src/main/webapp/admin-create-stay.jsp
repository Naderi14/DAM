<%--
  Created by IntelliJ IDEA.
  User: Fran
  Date: 08/05/2025
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="text-center">
        <h2>CREATE NEW STAY</h2>
    </div>
    <form method="post">
        <div class="row g-3 my-4">
            <div class="col-sm-12">
                <label for="stayTitle" class="form-label">Stay Title</label>
                <input type="text" class="form-control" id="stayTitle" placeholder="" value="" required="">
            </div>
            <div class="col-sm-12">
                <label for="stayDescription" class="form-label">Description <span class="text-body-secondary">(Optional)</span></label>
                <input type="text" class="form-control" id="stayDescription" placeholder="" value="">
            </div>
            <div class="col-6">
                <label for="stayAddress" class="form-label">Address</label>
                <input type="text" class="form-control" id="stayAddress" placeholder="1234 Main St" value="" required="">
            </div>
            <div class="col-3">
                <label for="country" class="form-label">State</label>
                <select class="form-select" id="country" required="">
                    <option value="">Choose...</option><option>Albania</option><option>Andorra</option><option>Armenia</option><option>Austria</option><option>Azerbaijan</option><option>Belarus</option><option>Belgium</option><option>Bosnia and Herzegovina</option><option>Bulgaria</option><option>Croatia</option><option>Cyprus</option><option>Czech Republic</option><option>Denmark</option><option>Estonia</option><option>Finland</option><option>France</option><option>Georgia</option><option>Germany</option><option>Greece</option><option>Hungary</option><option>Iceland</option><option>Ireland</option><option>Italy</option><option>Kazakhstan</option><option>Kosovo</option><option>Latvia</option><option>Liechtenstein</option><option>Lithuania</option><option>Luxembourg</option><option>Malta</option><option>Moldova</option><option>Monaco</option><option>Montenegro</option><option>Netherlands</option><option>North Macedonia</option><option>Norway</option><option>Poland</option><option>Portugal</option><option>Romania</option><option>Russia</option><option>San Marino</option><option>Serbia</option><option>Slovakia</option><option>Slovenia</option><option>Spain</option><option>Sweden</option><option>Switzerland</option><option>Turkey</option><option>Ukraine</option><option>United Kingdom</option><option>Vatican City</option>
                </select>
            </div>
            <div class="col-3">
                <label for="city" class="form-label">City name <span class="text-body-secondary">(Optional)</span></label>
                <input type="text" class="form-control" id="city" placeholder="City" value="">
            </div>
            <div class="col-6">
                <label for="price" class="form-label">Price</label>
                <div class="input-group">
                    <input type="text" id="price" class="form-control" aria-label="Amount (to the nearest euro)" required="">
                    <div class="input-group-append">
                        <span class="input-group-text">€</span>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <label for="mainImage" class="form-label">Front Page Image Path</label>
                <input type="text" id="mainImage" class="form-control" required="">
            </div>
            <div class="col-md-3">
                <label for="maxGuests" class="form-label">Max Guests</label>
                <input type="number" class="form-control" id="maxGuests" placeholder="" required="">
            </div>
            <div class="col-md-3">
                <label for="numBathrooms" class="form-label">Num Bathrooms</label>
                <input type="number" class="form-control" id="numBathrooms" placeholder="" required="">
            </div>
            <div class="col-md-3">
                <label for="numBedrooms" class="form-label">Num Bedrooms</label>
                <input type="number" class="form-control" id="numBedrooms" placeholder="" required="">
            </div>
            <div class="col-md-3">
                <label for="numBeds" class="form-label">Num Beds</label>
                <input type="number" class="form-control" id="numBeds" placeholder="" required="">
            </div>
        </div>
        <button class="w-100 btn btn-primary btn-lg" type="submit">Create Stay</button>
    </form>
</body>
</html>
