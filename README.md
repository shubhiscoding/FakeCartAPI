# FakeCartAPI
## How To Run This API
### Get all carts
```
Perform a GET method call to this endpoint => 'http://localhost:8080/carts'
```
#### Expected Output
```
  //output
            [
                {
                    id:1,
                    userId:1,
                    date:2020-10-10,
                    products:[{productId:2,quantity:4},{productId:1,quantity:10},{productId:5,quantity:2}]
                },
                /*...*/
                {
                    id:20,
                    userId:10,
                    date:2019-10-10,
                    products:[{productId:1,quantity:5},{productId:5,quantity:1}]
                }
            ]
```
### Get a Single Cart
```
Perform a GET method call to this endpoint => 'http://localhost:8080/cart/{fill in the respective cart id here}'
```
#### Expected Output
```
 //output
            {
              "id": 5,
              "userId": 3,
              "date": "2020-03-01T00:00:00.000+00:00",
              "products": [
                  {
                      "productId": 7,
                      "quantity": 1
                  },
                  {
                      "productId": 8,
                      "quantity": 1
                  }
              ]
          }
```
### Get carts in a date range
```
Perform a GET method call to this endpoint =>
'http://localhost:8080/carts?startdate={fill in the start date here}&enddate={fill in the end date here}'
Date should be in (YYYY-MM-DD) format.
```
#### Expected Output
```
//output
        [
            {
                id:1,
                userId:1,
                date:2019-12-10,
                products:[...]
            },
            /*...*/
            {
                id:4,
                userId:1,
                date:2020-10-10,
                products:[...]
            }
        ]
```

#### Get User Carts
```
Perform a GET method call to this endpoint => 'http://localhost:8080/carts/user/{id}'
```
#### Expected Output
```
 //output
            [
            {
                id:5,
                userId:2,
                date:2019-10-03,
                products:[...]
            },
            /*...*/
            {
                id:6,
                userId:2,
                date:2020-10-10,
                products:[...]
            }
        ]
```
### Add a New Cart
```
Perform a POST method call to this endpoint => 'http://localhost:8080/carts'
and send a cart in form of JSON as request body
ex:
{
    "id": 22,
    "userId":5,
    "date": null,
    "products":[
        {
            "productId":5,
            "quantity": 1
        }
    ]
}
```
#### Expected Output
```
//output
        {
            "id": 11,
            "userId": 5,
            "date": null,
            "products": [
                {
                    "productId": 5,
                    "quantity": 1
                }
            ]
        }
```
### Update Product
```
Perform a PUT method call to this endpoint => 'http://localhost:8080/cart/{fill in the respective cart id here}'
and send a cart in form of JSON as request body
ex:
{
    "id": 22,
    "userId":5,
    "date": null,
    "products":[
        {
            "productId":5,
            "quantity": 1
        }
    ]
}
```
#### Expected Output
```
//Ouput
  "Cart Updated"
```

### Delete Product
```
Perform a DELETE method call to this endpoint => 'http://localhost:8080/cart/{fill in the respective cart id here}'
```
#### Expected Output
```
//Ouput
  "Cart Deleted"
```
