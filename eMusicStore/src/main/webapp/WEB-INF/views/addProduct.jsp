<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script>
    change = function(e) {
        console.log("checked value " + e.currentTarget.value);
        var radio1 = document.getElementById('category1');
        var radio2 = document.getElementById('category3');
        var radio3 = document.getElementById('category2');
        var select1=document.getElementById("subcategory1");
        var select3=document.getElementById("subcategory3");
        if (radio1.checked) {

            select3.disabled=!select3.disabled;
            select1.disabled=false;
            document.getElementById("ins").style.display = "block";
            document.getElementById("acc").style.display = "none";
        }
        if (radio2.checked) {

            select1.disabled=!select1.disabled;
            select3.disabled=false;
            document.getElementById("ins").style.display = "none";
            document.getElementById("acc").style.display = "block";
        }
        if(radio3.checked){

            select1.disabled=!select1.disabled;
            select3.disabled=!select3.disabled;
            document.getElementById("ins").style.display = "none";
            document.getElementById("acc").style.display = "none";
        }
    }


</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/product/addProduct" method="post"
                   commandName="product" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">Name</label> <form:errors path="productName" cssStyle="color: #ff0000;" />
            <form:input path="productName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category1" value="instrument" name="myRadios"
                                                             onchange="change(event)" />Instrument</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category2" value="records" name="myRadios"
                                                             onchange="change(event)"/>Record</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category3" value="accessory" name="myRadios"
                                                             onchange="change(event)" />Accessory</label>
        </div>
        <div id="ins" class="form-group" style="display: none">
            <label for="subcategory1">Subcategory</label>
            <form:select path="productSubCategory" id="subcategory1">
                <form:option value="bass&guitar">Bass&Guitar</form:option>
                <form:option value="drums">drums</form:option>
                <form:option value="keyboards">keyboards</form:option>
                <form:option value="strings">strings</form:option>
                <form:option value="winds">winds</form:option>
                <form:option value="djsets">djsets</form:option>
            </form:select>
        </div>
        <div id="acc" class="form-group" style="display: none">
            <label for="subcategory3">Subcategory</label>
            <form:select path="productSubCategory" id="subcategory3">
                <form:option value="cables">cables</form:option>
                <form:option value="misc">miscellaneous</form:option>
                <form:option value="headphones">headphones</form:option>
                <form:option value="amplifiers">amplifiers</form:option>
                <form:option value="picks&capos">picks&capos</form:option>
                <form:option value="corde">instrument_strings</form:option>
            </form:select>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" id="description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label>  <form:errors path="productPrice" cssStyle="color: #ff0000;" />
            <form:input path="productPrice" id="price" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="new" />New</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="used" />Used</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="promo" />Promo</label>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                             value="active" />Active</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                             value="inactive" />Inactive</label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>  <form:errors path="unitInStock"
                                                                         cssStyle="color: #ff0000;" />
            <form:input path="unitInStock" id="unitInStock" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-Control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
