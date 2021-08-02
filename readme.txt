
Following features are implemented in project.

1. Get the product rating
2. Add rating to a product
3. Update rating of a product

Example API usage:
GET Method : http://localhost:9090/api/v1/products/1/ratings
POST Method : http://localhost:9090/api/v1/products/1/ratings/8
PUT Method : http://localhost:9090/api/v1/products/1/ratings
{
  id : 1,
  rating : 9,
  productId : 1
}


Technology stack used :
Spring Rest, Maven, Spring Data JPA, H2 in memory database, Junit 4, Mockito

Steps to run project : 
1. clone git repository
2. import project as an existing maven/spring boot project in Eclipse.
3. run as spring boot app