# sec_a_chandru.raj__corejava_project_2
## **Redefine**

****Milestones**[**enter link description here](https://github.com/fssa-batch3/sec_a_chandru.raj__corejava_project_2/milestones)
ER Diagram [enter link description here](https://freeimage.host/i/HDDkYMb)
[![HDDkYMb.png](https://iili.io/HDDkYMb.png)](https://freeimage.host/)


### Attributes

-   name
-   email
-   password

### Validations

-   validateUser
-   validateEmail
-   validatePassword
-   validateName

### Validation Test

-   testValidateUser
-   testValidateEmail
-   testValidatePassword
-   testValidateName

### DAO

-   createUser

### Service

-   registerUser

### Test

-   testRegisterFeature

**Flow:**
```mermaid  
flowchart TD
A[Start]  
B[Display Registration Form]  
C[User Fills out Form]  
D[Validate Input]  
E{Validation Successful?}  
F[Save User Data]  
G[Registration Successful]  
H[Display Error Messages]  
I[End]  
A --> B  
B --> C  
C --> D  
D --> E  
E -- Yes --> F  
F --> G  
E -- No --> H  
H --> B  
H --> I  
G --> I  
```
