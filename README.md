# Springboot
1. Form Validation Workflow in Spring MVC:

    Data Binding: Form data is bound to a Java object using @ModelAttribute.
    Validation: The form object is validated using annotations from javax.validation (@NotNull, @Size, etc.).
    Error Handling: Errors are captured using the BindingResult interface.

2. Key Annotations for Validation:
Annotation	Description	Example
@NotNull	Field must not be null	@NotNull private String name;
@Size	Validates size constraints (length)	@Size(min=3, max=20)
@Email	Validates email format	@Email private String email;
@Pattern	Validates using a regex pattern	@Pattern(regexp="\\d+")
@Min/@Max	Validates minimum/maximum numerical values	@Min(18)
@NotBlank	Field must not be empty (for strings)	@NotBlank private String name;
3. Controller Setup:

@Controller
public class SignupController {

    @PostMapping("/process")
    public String processForm(
        @Valid @ModelAttribute("login_Data") LoginData loginData, 
        BindingResult result, 
        Model model) {
        
        if (result.hasErrors()) {
            return "signupForm"; // Return to the form if errors exist
        }
        // Process the valid form data
        return "successPage";
    }
}

    @Valid: Triggers validation.
    BindingResult: Captures validation errors.

4. Form Class Example:

public class LoginData {
    
    @NotBlank(message = "User name is required")
    private String userName;

    @Email(message = "Enter a valid email")
    private String email;

    @AssertTrue(message = "You must agree to terms")
    private Boolean agreed;

    // Getters and Setters
}

5. Thymeleaf Integration:

    Use the #fields utility to handle errors:

<input type="text" th:field="*{userName}" class="form-control" 
       th:classappend="${#fields.hasErrors('userName') ? 'is-invalid' : ''}">
<div th:if="${#fields.hasErrors('userName')}" class="invalid-feedback" 
     th:each="error : ${#fields.errors('userName')}" th:text="${error}"></div>

6. Validation Messages:

    Custom Messages: Use the message attribute in annotations.
    Messages File: Store messages in a messages.properties file.

userName.NotBlank=User Name cannot be blank
email.Email=Please provide a valid email
