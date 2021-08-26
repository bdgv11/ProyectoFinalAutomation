package Tests;

import PageObjects.RegisterPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTests extends BaseClass {

    /*
    Caso #1
    Verificar que el sitio web permite el registro a nuevos clientes.
    Ir al sitio web.
    Ir a la página de registro.
    Crear un usuario nuevo. (Utilizar un método aleatorio para generar el email)
    Verificar que el usuario está logueado.
     */

    @Description("This is the first test fro final project")
    @Test(description = "Test to create a new user")
    public void Test_Create_New_Account(){

        RegisterPage registerPage = new RegisterPage(driver);

        //SETUP
        String firstName = "Bryan";
        String lastName = "Guzman";
        String email = registerPage.randomEmail(10);
        String telephone = registerPage.randomTelephone(10);
        String password = "test12345678";
        String expectedMessage = "Your Account Has Been Created!";

        //RUN
        registerPage.GoToRegisterPage();
        registerPage.FillForm(firstName, lastName, email, telephone, password);

        //VALIDATION
        Assert.assertEquals(registerPage.GetConfirmationMessage(), expectedMessage);
    }

}
