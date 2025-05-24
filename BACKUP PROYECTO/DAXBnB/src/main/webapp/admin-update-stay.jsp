<%@ page import="daxbnb.model.Stay" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="daxbnb.DAO.StaysDAO" %>
<%@ page import="daxbnb.exceptions.stays.StayNotFoundException" %>
<%@ page import="daxbnb.DAO.CategoriesDAO" %>
<%@ page import="daxbnb.model.Category" %><%--
  Created by IntelliJ IDEA.
  User: Fran
  Date: 08/05/2025
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <%
        String action = null;

        StaysDAO staysDAO = new StaysDAO();
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        List<Category> categories;

        Stay selectedStay = null;
        List<Stay> stays;
        List<HashMap<String, String>> imagesData;

        try {
            stays = staysDAO.getAllStays();
            categories = categoriesDAO.getAllCategories();
        } catch (SQLException | StayNotFoundException e) {
            throw new RuntimeException(e);
        }

        if ("POST".equalsIgnoreCase(request.getMethod()))
        {
            action = request.getParameter("action");

            if ("update-stay-select".equalsIgnoreCase(action))
            {
                if (request.getParameter("idStayForUpdate") != null)
                {
                    try {
                        selectedStay = staysDAO.getStayById(Integer.parseInt(request.getParameter("idStayForUpdate")));
                    } catch (SQLException | StayNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            else if ("update-stay-submit".equalsIgnoreCase(action))
            {
                String title = request.getParameter("stay")
            }
        }
    %>
    <div class="text-center">
        <h2>UPDATE STAY</h2>
    </div>
    <form method="post">
        <div class="col-12 my-3">
            <label for="idStayForUpdate" class="form-label">Select ID Stay</label>
            <input type="hidden" name="action" value="update-stay-select"/>
            <select class="form-select" name="idStayForUpdate" id="idStayForUpdate" required="">
                <option value="">Choose...</option>
                <% for (Stay stay : stays) { %>
                <option value="<%= stay.getIdStay() %>">
                    <%= stay.getIdStay() %> - <%= stay.getTitle() %> - <%= stay.getCity() %>
                </option>
                <% } %>
            </select>
        </div>
        <button class="w-100 btn btn-primary btn-lg" type="submit">Select</button>
    </form>
    <% if (selectedStay != null) { %>
            <hr class="my-3">
            <form method="post" action="">
                <div class="row g-3 my-4">
                    <div class="col-sm-6">
                        <label for="stayTitleUpdate" class="form-label">Stay Title</label>
                        <input type="text" class="form-control" name="stayTitleUpdate" id="stayTitleUpdate" placeholder="" value="<%= selectedStay.getTitle() %>" required="">
                    </div>
                    <div class="col-6 my-4">
                        <label for="stayCategoryUpdate" class="form-label">Categorie</label>
                        <select class="form-select" name="stayCategoryUpdate" id="stayCategoryUpdate" required="">
                            <option value="">Choose...</option>
                            <% for (Category category : categories) { %>
                            <option value="<%= category.getIdCategory() %>">
                                <%= category.getCategoryName() %>
                            </option>
                            <% } %>
                        </select>
                    </div>
                    <div class="col-sm-12">
                        <label for="stayDescriptionUpdate" class="form-label">Description <span class="text-body-secondary">(Optional)</span></label>
                        <input type="text" class="form-control" name="stayDescriptionUpdate" id="stayDescriptionUpdate" placeholder="" value="<%= selectedStay.getDescription() %>">
                    </div>
                    <div class="col-sm-6">
                        <label for="stayAddressUpdate" class="form-label">Address</label>
                        <input type="text" class="form-control" name="stayAddressUpdate" id="stayAddressUpdate" placeholder="1234 Main St" value="<%= selectedStay.getAddress() %>" required="">
                    </div>
                    <div class="col-sm-6">
                        <label for="priceUpdate" class="form-label">Price</label>
                        <div class="input-group">
                            <input type="text" name="priceUpdate" id="priceUpdate" value="<%= selectedStay.getPrice() %>" class="form-control" aria-label="Amount (to the nearest euro)" required="">
                            <div class="input-group-append">
                                <span class="input-group-text">€</span>
                            </div>
                        </div>
                    </div>
                    <%  try {
                            imagesData = staysDAO.getImagesDataByStay(selectedStay.getIdStay());
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        for (HashMap<String, String> imageData : imagesData) { %>
                    <div class="col-md-12">
                        <label for="image<%= imageData.get("idImage") %>" class="form-label">Image <%= imageData.get("idImage") %></label>
                        <div class="input-group">
                            <input type="text" name="image<%= imageData.get("idImage") %>Path" id="image<%= imageData.get("idImage") %>Path" value="<%= imageData.get("path") %>" class="form-control" required="">
                            <div class="input-group-append">
                                <input type="text" name="image<%= imageData.get("idImage") %>Description" id="image<%= imageData.get("idImage") %>Description" value="<%= imageData.get("description") %>" class="form-control" required="">
                            </div>
                        </div>
                    </div>
                    <%  } %>
                    <div class="col-md-12">
                        <label for="newImagePath" class="form-label">New Image <span class="text-body-secondary">(Optional)</span></label>
                        <div class="input-group">
                            <input type="text" name="newImagePath" id="newImagePath" value="" class="form-control">
                            <div class="input-group-append">
                                <input type="text" name="newImageDescription" id="newImageDescription" value="" class="form-control">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <label for="maxGuestsUpdate" class="form-label">Max Guests</label>
                        <input type="number" class="form-control" name="maxGuestsUpdate" id="maxGuestsUpdate" value="<%= selectedStay.getNumGuests() %>" placeholder="" required="">
                    </div>
                    <div class="col-md-3">
                        <label for="numBathroomsUpdate" class="form-label">Num Bathrooms</label>
                        <input type="number" class="form-control" name="numBathroomsUpdate" id="numBathroomsUpdate" value="<%= selectedStay.getNumBaths() %>" placeholder="" required="">
                    </div>
                    <div class="col-md-3">
                        <label for="numBedroomsUpdate" class="form-label">Num Bedrooms</label>
                        <input type="number" class="form-control" name="numBedroomsUpdate" id="numBedroomsUpdate" value="<%= selectedStay.getNumBedrooms() %>" placeholder="" required="">
                    </div>
                    <div class="col-md-3">
                        <label for="numBedsUpdate" class="form-label">Num Beds</label>
                        <input type="number" class="form-control" name="numBedsUpdate" id="numBedsUpdate" value="<%= selectedStay.getNumBeds() %>" placeholder="" required="">
                    </div>
                </div>
                <input type="hidden" name="action" value="update-stay-submit"/>
                <input type="hidden" name="id-stay" value="<%= selectedStay.getIdStay() %>">
                <button class="w-100 btn btn-primary btn-lg" type="submit">Update Stay</button>
            </form>
        <% } %>
</body>
</html>
