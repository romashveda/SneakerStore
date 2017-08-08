<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<aside class="filter">
    <div class="widget">
        <section class="listscroll">
            <div class="filter-section">
            <%--<form action="filter" method="post">--%>
                <div class="filter-section-h">Brand</div>
                <div class="filter-list j-filter-list">
                    <ul class="filter-lv1">
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <%--<c:forEach items="${brands}" var="b">--%>
                                    <%--<input type="checkbox" name="${b.brand}">--%>
                                <%--</c:forEach>--%>
                                <%--&lt;%&ndash;<input type="checkbox" name="brand" value="Male">Male&ndash;%&gt;--%>
                                <%--<sf:checkboxes path="brand" items="${brands}"/>--%>
                            </a>
                        </li>
                        <%--<li class="filter-lv1-i">--%>
                            <%--<a class="filter-check" href="#">--%>
                                <%--<input type="checkbox" value="Male">Female--%>
                            <%--</a>--%>
                        <%--</li>--%>
                    </ul>
                </div>
            </div>
            <div class="filter-section">
                <div class="filter-section-h">Category</div>
                <div class="filter-list j-filter-list">
                    <ul class="filter-lv1">
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="Running">Running
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="Street">Street
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="Training">Training
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="Skateboarding">Skateboarding
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="Male">Basketball
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="filter-section">
                <div class="filter-section-h">Brand</div>
                <div class="filter-list j-filter-list">
                    <ul class="filter-lv1">
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="Adidas">Adidas
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="Asics">Asics
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="Jordan Brand">Jordan Brand
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="New Balance">New Balance
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="Nike">Nike
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="Puma">Puma
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="Reebok">Reebok
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="Vans">Vans
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="filter-section">
                <div class="filter-section-h">Size</div>
                <div class="filter-list j-filter-list">
                    <ul class="filter-lv1">
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="36">36
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="37">37
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="38">38
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="39">39
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="40">40
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="41">41
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="42">42
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="43">43
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="44">44
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="45">45
                            </a>
                        </li>
                        <li class="filter-lv1-i">
                            <a class="filter-check" href="#">
                                <input type="checkbox" value="46">46
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="filter-section">
                <div class="filter-section-h">Color</div>
                <div class="filter-list j-filter-list">
                    <div class="filter-color-list">
                        <a href="#" class="filter-color-i">
                            <i class="filter-color-b" style="background: red;"></i>
                        </a>
                        <a href="#" class="filter-color-i">
                            <i class="filter-color-b" style="background: black;"></i>
                        </a>
                        <a href="#" class="filter-color-i">
                            <i class="filter-color-b" style="background: snow;"></i>
                        </a>
                        <a href="#" class="filter-color-i">
                            <i class="filter-color-b" style="background: grey;"></i>
                        </a>
                        <a href="#" class="filter-color-i">
                            <i class="filter-color-b" style="background: yellow;"></i>
                        </a>
                        <a href="#" class="filter-color-i">
                            <i class="filter-color-b" style="background: blue;"></i>
                        </a>
                        <a href="#" class="filter-color-i">
                            <i class="filter-color-b" style="background: green;"></i>
                        </a>
                        <a href="#" class="filter-color-i">
                            <i class="filter-color-b" style="background: purple;"></i>
                        </a>
                        <a href="#" class="filter-color-i">
                            <i class="filter-color-b" style="background: brown;"></i>
                        </a>
                    </div>
                </div>
                <%--<sf:button>Submit</sf:button>--%>
                <%--<form>--%>
            </div>
        </section>
    </div>
</aside>