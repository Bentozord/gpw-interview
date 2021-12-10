# GPW Tech Interview Task Part 2

Simply CRUD application for managing user in cabaret shop.
Simple validations, simple user domain model.

My main focus was on simple, clean solutions including very simple domain model.
Trying to keep in mind the RESTful constraints and good practices while implementing API and other principles.

###Main goals:

1. simple domain model seperated from the rest
2. rest api that follows RESTful constraints
3. package scope visibility(only Facade is public)
4. Hexagonal architecture approach(with one way to enter package point 3.)
5. As less external dependencies as possible
6. Test only Facade - business functionality place(one port to our adapter) - simple unit tests
7. SOLID, CleanCode approach
8. No Autowired annotations, focused on proper initialization of Components for tests

###Thins to have in mind:
1. Guidelines about RESTful APIs
2. Security - omitted here(simplicity)
3. Wrapper for UserId(UUID used for simplicity)
4. Lombok omitted which lead to a lot of boilerplate code generation(but no external depend.)
5. More strict validation on input(we could sanitaze, filter, validate data - owasp style)
6. ErrorHandling(eg. with ControllerAdvice - but still not the best approach)
7. Proper DB for given problem, but InMemory still okay
8. Swagger, versioning, HTTP headers, actuator etc. 

---
