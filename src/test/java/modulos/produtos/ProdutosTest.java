package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web no módulo de produtos")
public class ProdutosTest {

    private WebDriver navegador;



    @BeforeEach
    public void beforeEach(){
        //Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //Vou maximizar a tela

        this.navegador.manage().window().maximize();

        // Definir tempo de esperar padrao de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a pagina da lojinha web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com valor igual a zero")
     public void testeNaoEPermitidoRegistrarProdutosComValorIGualAZero(){



        //Fazer Login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeProduto()
                .informarNomeDoProduto("merma coisa")
                .informarValorDoProduto("000")
                .informarCoresDoProduto("Vantablack")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();


        //Vou preencher dados do produto e o valor sera igual a zero
        //navegador.findElement(By.id("produtonome")).sendKeys(("Osuperthiago"));
        //navegador.findElement(By.name("produtovalor")).sendKeys("000");
        //navegador.findElement(By.id("produtocores")).sendKeys(("Azul, Blanc"));

        //Vou submeter o formulario
        //navegador.findElement(By.cssSelector("button[type='submit']")).click();

        // Vou validar que a mensagem de erro foi apresentada
        //<div class="toast rounded" style="top: 0px; transition: transform 0.2s ease 0s, opacity 0.2s ease 0s; opacity: 1; margin-top: 10px;">O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00</div>
        //String mensagemToast = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);


    }

    @Test
    @DisplayName("Nao e permitido registrar um produto com valor Maior que 7000,00")
    public void testeNaoEPermitidoRegistrarProdutosComValorMaiorQueSeteMil (){



        //Fazer Login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeProduto()
                .informarNomeDoProduto("merma coisa")
                .informarValorDoProduto("700100")
                .informarCoresDoProduto("Vantablack")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();


        //Vou preencher dados do produto e o valor sera igual a zero
        //navegador.findElement(By.id("produtonome")).sendKeys(("Osuperthiago"));
        //navegador.findElement(By.name("produtovalor")).sendKeys("000");
        //navegador.findElement(By.id("produtocores")).sendKeys(("Azul, Blanc"));

        //Vou submeter o formulario
        //navegador.findElement(By.cssSelector("button[type='submit']")).click();

        // Vou validar que a mensagem de erro foi apresentada
        //<div class="toast rounded" style="top: 0px; transition: transform 0.2s ease 0s, opacity 0.2s ease 0s; opacity: 1; margin-top: 10px;">O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00</div>
        //String mensagemToast = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",mensagemApresentada);


    }


    @Test
    @DisplayName("E permitido registrar um produto com valor entre 0,01 e 7000,00")
    public void testeEPermitidoRegistrarProdutosComValorMaiorQueZeroEMenorQueSeteMil (){



        //Fazer Login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeProduto()
                .informarNomeDoProduto("merma coisa")
                .informarValorDoProduto("1717")
                .informarCoresDoProduto("Vantablack")
                .submeterFormularioDeAdicaoComAcerto()
                .capturarMensagemApresentadaComAcerto() ;


        //Vou preencher dados do produto e o valor sera igual a zero
        //navegador.findElement(By.id("produtonome")).sendKeys(("Osuperthiago"));
        //navegador.findElement(By.name("produtovalor")).sendKeys("000");
        //navegador.findElement(By.id("produtocores")).sendKeys(("Azul, Blanc"));

        //Vou submeter o formulario
        //navegador.findElement(By.cssSelector("button[type='submit']")).click();

        // Vou validar que a mensagem de erro foi apresentada
        //<div class="toast rounded" style="top: 0px; transition: transform 0.2s ease 0s, opacity 0.2s ease 0s; opacity: 1; margin-top: 10px;">O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00</div>
        //String mensagemToast = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("Produto adicionado com sucesso",mensagemApresentada);


    }








    @AfterEach
    public void afterEach(){
        //Fechar o navegador
        navegador.quit();

    }


}
