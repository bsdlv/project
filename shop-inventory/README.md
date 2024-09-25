# WESTERN GOVERNORS UNIVERSITY
## D287 – JAVA FRAMEWORKS
<strong>C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.</strong>

--Filename modified: mainscreen.html

Title changed on line 14

`<title>Matt's Melts</title>`

h1 Shop changed on line 19

`<h1>Welcome to sandwich paradise</h1>`

h2 Parts changed on line 21

`<h2>Deli</h2>`

h2 Products changed on line 53

`<h2>Kitchen</h2>`

<strong>D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.</strong>

--Filename modified: mainscreen.html

Link added to About Us page on line 20

`<a href="/about">About Us</a>`

--Filename modified: MainScreenControllerr

Mapping added for /about to return about.html on lines 55-58

```
@GetMapping("/about")
public String about(){
    return "about.html";
}
```

--Filename created: about.html

Added about.html page as instructed in prompt with mainscreen template and link back to main page, lines 1-31

```
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta charset="UTF-8">

		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- Bootstrap CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
			  integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

		<title>About Matt's Melts</title>
	</head>
	<body>
		<h1>About Us</h1>
		<p>At Matt's Melts, we are passionate about bringing gourmet subs and premium deli meats right to your door. Our journey began with a simple idea: to make the high-quality, freshly-made sandwiches we loved accessible to anyone, anywhere, anytime. By freezing our subs at their peak freshness, we ensure that every bite is just as flavorful as if it were made moments ago in your favorite deli. Whether you're stocking up for the week or grabbing a quick lunch, we've got you covered with a diverse menu of delicious subs and deli meats that cater to all tastes.</p>

        <p>At Matt's Melts we are passionate about bringing gourmet subs and premium deli meats right to your door. Our journey began with a simple idea: to make the high-quality, freshly-made sandwiches we loved accessible to anyone, anywhere, anytime. By freezing our subs at their peak freshness, we ensure that every bite is just as flavorful as if it were made moments ago in your favorite deli. Whether you're stocking up for the week or grabbing a quick lunch, we've got you covered with a diverse menu of delicious subs and deli meats that cater to all tastes.</p>

		<p>We carefully select the finest ingredients for our products, from slow-cooked, tender meats to artisan breads and fresh veggies. Every sub is crafted with attention to detail, flash-frozen to lock in freshness, and packaged for convenience without sacrificing quality. Our deli meats, ranging from classic smoked turkey to robust pastrami, are sliced to perfection and designed to give you the same deli experience in your own kitchen. With Matt's Melts, you never have to compromise between convenience and quality.</p>

		<p>Our commitment to customer satisfaction drives everything we do. We believe in making great food accessible and stress-free, which is why our online store is easy to use, our shipping is fast, and our customer service team is always ready to assist. Whether you're a sandwich connoisseur or just looking for a reliable, delicious meal, Matt's Melts is here to satisfy your cravings—one frozen sub at a time.</p>

		<p>We carefully select the finest ingredients for our products, from slow-cooked, tender meats to artisan breads and fresh veggies. Every sub is crafted with attention to detail, flash-frozen to lock in freshness, and packaged for convenience without sacrificing quality. Our deli meats, ranging from classic smoked turkey to robust pastrami, are sliced to perfection and designed to give you the same deli experience in your own kitchen. With Matt's Melts, you never have to compromise between convenience and quality.</p>

		<p>Our commitment to customer satisfaction drives everything we do. We believe in making great food accessible and stress-free, which is why our online store is easy to use, our shipping is fast, and our customer service team is always ready to assist. Whether you're a sandwich connoisseur or just looking for a reliable, delicious meal, Matt's Melts is here to satisfy your cravings—one frozen sub at a time.</p>
		<br>
		<a href="/mainscreen">Back to homepage</a>
	</body>
</html>
```

<strong>E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.</strong>

--Filename modified: BootStrapData.java

Added inhousePartRepository to the class variables on line 31

`private final InhousePartRepository inhousePartRepository;`

Added inhousePartRepository to constructor on line 34, initialized on line 37

`public BootStrapData(PartRepository partRepository, ProductRepository productRepository, InhousePartRepository inhousePartRepository, OutsourcedPartRepository outsourcedPartRepository) {`

`this.inhousePartRepository = inhousePartRepository;`

Added parts to part repository as instructed, 2 inhouse and 3 outsourced parts, as well as 5 products to product repository. The sample data is only populated if the repositories are completely empty. Lines 44-108

```
List<InhousePart>inhouseParts=(List<InhousePart>)inhousePartRepository.findAll();
List<OutsourcedPart>outsourcedParts=(List<OutsourcedPart>)outsourcedPartRepository.findAll();
List<Product> products = (List<Product>) productRepository.findAll();

if(inhouseParts.isEmpty()&&outsourcedParts.isEmpty()&&products.isEmpty()) {
    InhousePart in1 = new InhousePart();
    in1.setName("Salami");
    in1.setInv(5);
    in1.setPrice(10);
    in1.setId(001);
    in1.setMinInv(0);
    in1.setMaxInv(50);
    inhousePartRepository.save(in1);

    InhousePart in2 = new InhousePart();
    in2.setName("Ham");
    in2.setInv(5);
    in2.setPrice(8);
    in2.setId(002);
    in2.setMinInv(0);
    in2.setMaxInv(50);
    inhousePartRepository.save(in2);

    OutsourcedPart out1 = new OutsourcedPart();
    out1.setCompanyName("Yorkshire Farms");
    out1.setName("Provolone");
    out1.setInv(3);
    out1.setPrice(8.0);
    out1.setId(100L);
    out1.setMinInv(0);
    out1.setMaxInv(50);
    outsourcedPartRepository.save(out1);

    OutsourcedPart out2 = new OutsourcedPart();
    out2.setCompanyName("Amoroso Bakery");
    out2.setName("Bread");
    out2.setInv(12);
    out2.setPrice(2.0);
    out2.setId(101L);
    out2.setMinInv(0);
    out2.setMaxInv(50);
    outsourcedPartRepository.save(out2);

    OutsourcedPart out3 = new OutsourcedPart();
    out3.setCompanyName("Pete's Pickles");
    out3.setName("Pickles");
    out3.setInv(12);
    out3.setPrice(2.0);
    out3.setId(102L);
    out3.setMinInv(0);
    out3.setMaxInv(50);
    outsourcedPartRepository.save(out3);

    Product italian = new Product("Italian Melt", 10.0, 10);
    Product cuban = new Product("Cuban Melt", 10.0, 10);
    Product caprese = new Product("Caprese Melt", 10.0, 10);
    Product blt = new Product("BLT Melt", 10.0, 10);
    Product tuna = new Product("Tuna Melt", 10.0, 10);
    productRepository.save(italian);
    productRepository.save(cuban);
    productRepository.save(caprese);
    productRepository.save(blt);
    productRepository.save(tuna);

    inhouseParts=(List<InhousePart>)inhousePartRepository.findAll();
    outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
}

for(InhousePart part:inhouseParts){
    System.out.println(part.getName()+" "+part.getId());
}
for(OutsourcedPart part:outsourcedParts){
    System.out.println(part.getName()+" "+part.getCompanyName());
}
```

<strong>F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.</strong>

--Filename modified: mainscreen.html

Added a button to buy now next to the Update and Delete buttons that directs to /buyNow

`<a th:href="@{/buyNow(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3">Buy Now</a>`

--Filename created: BuyNowController.java

Added controller for the /buyNow route. It first checks whether the product is in stock. If so, it decrements the stock and directs to a success screen, else it directs to a failure screen. Lines 1-35

```
package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BuyNowController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/buyNow")
	public String buyNow(@RequestParam("productID")Long id, Model theModel) {
		Optional<Product> productBought=productRepository.findById(id);
		if(productBought.isPresent()) {
			Product product=productBought.get();
			if(product.getInv()>0){
				product.setInv(product.getInv()-1);
				productRepository.save(product);
				return "/buysuccess";
			}else{
				return "/buyfail";
			}
		}else{
			return "/buyfail";
		}
	}
}
```

--Filename created: buysuccess.html

View returned if buy successful. Lines 1-12

```
<!DOCTYPE html>
  <html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Product purchased successfully!</title>
  </head>
  <body>
    <h2>Purchase successful, please enjoy your goods!</h2>
    <br>
    <a href="/mainscreen">Return home</a>
  </body>
</html>
```

--Filename created: buyfail.html

View returned if buy failed. Lines 1-12

```
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="UTF-8">
	<title>Error - Product not purchased</title>
	</head>
	<body>
		<h2>Purchase failed, please try again</h2>
		<br>
		<a href="/mainscreen">Return home</a>
	</body>
</html>
```

<strong>G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.</strong>

--Filename modified: Part.java

Added two variables for minimum inventory value and maximum inventory value on lines 32-36

```
@Min(value=0,message = "Minimum inventory value must be positive")
int minInv;
@Min(value = 0,message = "Maximum inventory value must be positive")
@Max(value=50,message="Maximum inventory value exceeded")
int maxInv;
```

Initialized the variables in the constructor with default values on lines 50-51

```
this.minInv=0;
this.maxInv=50;
```

Added variables for user to set custom minimum and maximum inventory values to constructor and set them on lines 59, 64-65

```
public Part(long id, String name, double price, int inv, int minInv, int maxInv	) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.inv = inv;
    this.minInv=minInv;
    this.maxInv=maxInv;
}
```

Generated getters and setters for minInv and maxInv on lines 62-77

```
public int getMinInv() {
    return minInv;
}

public void setMinInv(int minInv) {
    this.minInv = minInv;
}

public int getMaxInv() {
    return maxInv;
}

public void setMaxInv(int maxInv) {
    this.maxInv = maxInv;
}

```

--Filenames modified: InhousePart.java, OutsourcedPart.java

Minimum and maximum inventory variables initialized to defaults on lines 18-19 of both files

```
this.minInv=0;
this.maxInv=50;
```

--Filename modified: BootStrapData.java

Set minimum and maximum inventory defaults for each part. This was repeated for each part: in1, in2, out1, out2, out3. Lines 54-55, 63-64, 73-74, 83-84, 93-94

```
in1.setMinInv(0);
in1.setMaxInv(50);

in2.setMinInv(0);
in2.setMaxInv(50);
...

```

--Filenames modified: InhousePartForm.html, OutsourcedPartForm.html

Added the following input fields for user to add minimum and maximum inventory controls for new inhouse and outsourced parts on lines 25-29 of both files

```
<p><input type="text" th:field="*{minInv}" placeholder="Minimum inventory" class="form-control mb-4 col-4"/></p>
<p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Inventory Error</p>
<p><input type="text" th:field="*{maxInv}" placeholder="Maximum inventory" class="form-control mb-4 col-4"/></p>
<p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Inventory Error</p>

```

--Filename modified: application.properties

Changed name of database from spring-boot-102 to matts-melts-db on line 6

```
spring.datasource.url=jdbc:h2:file:~/matts-melts-db
```

--Filename modified: Part.java

Added method to check that requested inventory is not below minimum or above maximum on line 137-143

```
public void validateInv(){
    if(this.inv<this.minInv){
        throw new RuntimeException("Inventory must be above minimum value");
    }else if(this.inv>this.maxInv){
        throw new RuntimeException("Inventory must be below maximum value");
    }
}
```

--Filename modified: PartServiceImpl.java, InhousePartServiceImpl.java, OutsourcedPartServiceImpl.java

Added validateInv() check before saving the part on line 59, 54, 52 respectively. All this does is check the inventory level is valid before saving.

```
thePart.validateInv();
```

<strong>H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.</strong>

--Filenames created: ValidMin.java, ValidMax.java

Added logic for interface to return error if constraint violated on lines 1-19

ValidMin.java
```
package com.example.demo.validators;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {MinValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention({ElementType.TYPE})
public @interface ValidMin {
	String message() default "Part count cannot be less than minimum constraint";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
```

ValidMax.java, same imports as above
```
@Constraint(validatedBy = {MaxValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMax {
	String message() default "Part count cannot be more than maximum constraint";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
```

--Filenames created: MinValidator.java, MaxValidator.java

Implemented logic to validate part count against inventory constraints on lines 1-24

MinValidator.java
```
package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinValidator implements ConstraintValidator<ValidMin, Part> {
	@Autowired
	private ApplicationContext applicationContext;
	public static ApplicationContext myContext;

	@Override
	public void initialize(ValidMin constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Part part, ConstraintValidatorContext context) {
		return part.getInv()>part.getMinInv();
	}
}
```

MaxValidator.java, same imports as above
```
public class MaxValidator implements ConstraintValidator<ValidMax, Part> {
	@Autowired
	private ApplicationContext applicationContext;
	public static ApplicationContext myContext;

	@Override
	public void initialize(ValidMax constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Part part, ConstraintValidatorContext context) {
		return part.getInv()<=part.getMaxInv();
	}
}
```

--Filename modified Part.java

Added minimum and maximum inventory constraints to Part on lines 22-23
```
@ValidMin
@ValidMax
```

--Filenames modified: InhousePartForm.html, OutsourcedPartForm.html

Added fields to display errors related to minimum and maximum constraints to both files on lines 25-28

```
<p><input type="text" th:field="*{minInv}" placeholder="Minimum inventory" class="form-control mb-4 col-4"/></p>
<p th:if="${#fields.hasErrors('minInv')}" th:errors="*{minInv}">Inventory Error</p>
<p><input type="text" th:field="*{maxInv}" placeholder="Maximum inventory" class="form-control mb-4 col-4"/></p>
<p th:if="${#fields.hasErrors('maxInv')}" th:errors="*{maxInv}">Inventory Error</p>
```

<strong>I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.</strong>

--Filename modified: PartTest.java

Added tests for the getters and setters for getMin/MaxInv and setMin/MaxInv on lines 160-194

```
@Test
void getMinInv(){
    int min_inv=10;
    partIn.setMinInv(min_inv);
    assertEquals(min_inv,partIn.getMinInv());
    partOut.setMinInv(min_inv);
    assertEquals(min_inv,partOut.getMinInv());
}

@Test
void getMaxInv(){
    int max_inv=150;
    partIn.setMaxInv(max_inv);
    assertEquals(max_inv,partIn.getMaxInv());
    partOut.setMaxInv(max_inv);
    assertEquals(max_inv,partOut.getMaxInv());
}

@Test
void setMinInv(){
    int min_inv=10;
    partIn.setMinInv(min_inv);
    assertEquals(min_inv,partIn.getMinInv());
    partOut.setMinInv(min_inv);
    assertEquals(min_inv,partOut.getMinInv());
}

@Test
void setMaxInv(){
    int max_inv=150;
    partIn.setMaxInv(max_inv);
    assertEquals(max_inv,partIn.getMaxInv());
    partOut.setMaxInv(max_inv);
    assertEquals(max_inv,partOut.getMaxInv());
}
```

<strong>J.  Remove the class files for any unused validators in order to clean your code.</strong>

--Filenames deleted: ValidDeletePart.java, DeletePartValidator.java

Unused validators deleted
