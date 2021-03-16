package com.joaogcm.api.geek.burguer.instantiate;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joaogcm.api.geek.burguer.entities.Address;
import com.joaogcm.api.geek.burguer.entities.Category;
import com.joaogcm.api.geek.burguer.entities.City;
import com.joaogcm.api.geek.burguer.entities.Client;
import com.joaogcm.api.geek.burguer.entities.Order;
import com.joaogcm.api.geek.burguer.entities.Payment;
import com.joaogcm.api.geek.burguer.entities.PaymentWithBoleto;
import com.joaogcm.api.geek.burguer.entities.PaymentWithCard;
import com.joaogcm.api.geek.burguer.entities.Product;
import com.joaogcm.api.geek.burguer.entities.State;
import com.joaogcm.api.geek.burguer.entities.enums.PaymentStatus;
import com.joaogcm.api.geek.burguer.entities.enums.TypeClient;
import com.joaogcm.api.geek.burguer.repositories.AddressRepository;
import com.joaogcm.api.geek.burguer.repositories.CategoryRepository;
import com.joaogcm.api.geek.burguer.repositories.CityRepository;
import com.joaogcm.api.geek.burguer.repositories.ClientRepository;
import com.joaogcm.api.geek.burguer.repositories.OrderRepository;
import com.joaogcm.api.geek.burguer.repositories.PaymentRepository;
import com.joaogcm.api.geek.burguer.repositories.ProductRepository;
import com.joaogcm.api.geek.burguer.repositories.StateRepository;

@Configuration
@Profile("test")
public class InstantiateClasses implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Category categoryOne = new Category(null, "Drinks");
		Category categoryTwo = new Category(null, "Hamburguers");
		Category categoryThree = new Category(null, "Others");

		Product productOne = new Product(null, "Bob Esponja", 16.00);
		Product productTwo = new Product(null, "Florinda-Shake", 15.00);
		Product productThree = new Product(null, "O Senhor dos Aneis", 12.00);
		Product productFour = new Product(null, "Pickle Rick", 24.00);

		categoryOne.getProducts().addAll(Arrays.asList(productTwo));
		categoryTwo.getProducts().addAll(Arrays.asList(productOne, productFour));
		categoryThree.getProducts().addAll(Arrays.asList(productThree));

		productOne.getCategories().addAll(Arrays.asList(categoryTwo));
		productTwo.getCategories().addAll(Arrays.asList(categoryOne));
		productThree.getCategories().addAll(Arrays.asList(categoryThree));
		productFour.getCategories().addAll(Arrays.asList(categoryTwo));

		categoryRepository.saveAll(Arrays.asList(categoryOne, categoryTwo, categoryThree));
		productRepository.saveAll(Arrays.asList(productOne, productTwo, productThree, productFour));

		State stateAcre = new State(null, "Acre");
		State stateAlagoas = new State(null, "Alagoas");
		State stateAmapa = new State(null, "Amapá");
		State stateAmazonas = new State(null, "Amazonas");
		State stateBahia = new State(null, "Bahia");
		State stateCeará = new State(null, "Ceará");
		State stateEspiritoSanto = new State(null, "Espírito Santo");
		State stateGoias = new State(null, "Goiás");
		State stateMaranhao = new State(null, "Maranhão");
		State stateMatoGrosso = new State(null, "Mato Grosso");
		State stateMatoGrossoDoSul = new State(null, "Mato Grosso do Sul");
		State stateMinasGerais = new State(null, "Minas Gerais");
		State statePara = new State(null, "Para");
		State stateParaiba = new State(null, "Paraíba");
		State stateParana = new State(null, "Paraná");
		State statePernambuco = new State(null, "Pernambuco");
		State statePiaui = new State(null, "Piauí");
		State stateRioDeJaneiro = new State(null, "Rio de Janeiro");
		State stateRioGrandeDoNorte = new State(null, "Rio Grande do Norte");
		State stateRioGrandeDoSul = new State(null, "Rio Grande do Sul");
		State stateRondonia = new State(null, "Rondônia");
		State stateRoraima = new State(null, "Roraíma");
		State stateSantaCatarina = new State(null, "Santa Catarina");
		State stateSaoPaulo = new State(null, "São Paulo");
		State stateSergipe = new State(null, "Sergipe");
		State stateTocantins = new State(null, "Tocantins");
		State stateDistritoFederal = new State(null, "Distrito Federal");

		City cityRioBranco = new City(null, "Rio Branco", stateAcre);
		City cityMaceio = new City(null, "Maceió", stateAlagoas);
		City cityMacapa = new City(null, "Macapá", stateAmapa);
		City cityManaus = new City(null, "Manaus", stateAmazonas);
		City citySalvador = new City(null, "Salvador", stateBahia);
		City cityFortaleza = new City(null, "Fortaleza", stateCeará);
		City cityVitoria = new City(null, "Vitória", stateEspiritoSanto);
		City cityGoiania = new City(null, "Goiânia", stateGoias);
		City citySaoLuis = new City(null, "São Luís", stateMaranhao);
		City cityCuiaba = new City(null, "Cuiabá", stateMatoGrosso);
		City cityCampoGrande = new City(null, "Campo Grande", stateMatoGrossoDoSul);
		City cityBeloHorizonte = new City(null, "Belo Horizonte", stateMinasGerais);
		City cityBelem = new City(null, "Belém", statePara);
		City cityJoaoPessoa = new City(null, "João Pessoa", stateParaiba);
		City cityCuritiba = new City(null, "Curitiba", stateParana);
		City cityRecife = new City(null, "Recife", statePernambuco);
		City cityTeresina = new City(null, "Teresina", statePiaui);
		City cityRioDeJaneiro = new City(null, "Rio de Janeiro", stateRioDeJaneiro);
		City cityNatal = new City(null, "Natal", stateRioGrandeDoNorte);
		City cityPortoAlegre = new City(null, "Porto Alegre", stateRioGrandeDoSul);
		City cityPortoVelho = new City(null, "Porto Velho", stateRondonia);
		City cityBoaVista = new City(null, "Boa Vista", stateRoraima);
		City cityFlorianopolis = new City(null, "Florianópolis", stateSantaCatarina);
		City citySaoPaulo = new City(null, "São Paulo", stateSaoPaulo);
		City cityAracaju = new City(null, "Aracaju", stateSergipe);
		City cityPalmas = new City(null, "Palmas", stateTocantins);
		City cityBrasilia = new City(null, "Brasilia", stateDistritoFederal);

		stateAcre.getCities().addAll(Arrays.asList(cityRioBranco));
		stateAlagoas.getCities().addAll(Arrays.asList(cityMaceio));
		stateAmapa.getCities().addAll(Arrays.asList(cityMacapa));
		stateAmazonas.getCities().addAll(Arrays.asList(cityManaus));
		stateBahia.getCities().addAll(Arrays.asList(citySalvador));
		stateCeará.getCities().addAll(Arrays.asList(cityFortaleza));
		stateEspiritoSanto.getCities().addAll(Arrays.asList(cityVitoria));
		stateGoias.getCities().addAll(Arrays.asList(cityGoiania));
		stateMaranhao.getCities().addAll(Arrays.asList(citySaoLuis));
		stateMatoGrosso.getCities().addAll(Arrays.asList(cityCuiaba));
		stateMatoGrossoDoSul.getCities().addAll(Arrays.asList(cityCampoGrande));
		stateMinasGerais.getCities().addAll(Arrays.asList(cityBeloHorizonte));
		statePara.getCities().addAll(Arrays.asList(cityBelem));
		stateParaiba.getCities().addAll(Arrays.asList(cityJoaoPessoa));
		stateParana.getCities().addAll(Arrays.asList(cityCuritiba));
		statePernambuco.getCities().addAll(Arrays.asList(cityRecife));
		statePiaui.getCities().addAll(Arrays.asList(cityTeresina));
		stateRioDeJaneiro.getCities().addAll(Arrays.asList(cityRioDeJaneiro));
		stateRioGrandeDoNorte.getCities().addAll(Arrays.asList(cityNatal));
		stateRioGrandeDoSul.getCities().addAll(Arrays.asList(cityPortoAlegre));
		stateRondonia.getCities().addAll(Arrays.asList(cityPortoVelho));
		stateRoraima.getCities().addAll(Arrays.asList(cityBoaVista));
		stateSantaCatarina.getCities().addAll(Arrays.asList(cityFlorianopolis));
		stateSaoPaulo.getCities().addAll(Arrays.asList(citySaoPaulo));
		stateSergipe.getCities().addAll(Arrays.asList(cityAracaju));
		stateTocantins.getCities().addAll(Arrays.asList(cityPalmas));
		stateDistritoFederal.getCities().addAll(Arrays.asList(cityBrasilia));

		stateRepository.saveAll(Arrays.asList(stateAcre, stateAlagoas, stateAmapa, stateAmazonas, stateBahia,
				stateCeará, stateEspiritoSanto, stateGoias, stateMaranhao, stateMatoGrosso, stateMatoGrossoDoSul,
				stateMinasGerais, statePara, stateParaiba, stateParana, statePernambuco, statePiaui, stateRioDeJaneiro,
				stateRioGrandeDoNorte, stateRioGrandeDoSul, stateRondonia, stateRoraima, stateSantaCatarina,
				stateSaoPaulo, stateSergipe, stateTocantins, stateDistritoFederal));

		cityRepository.saveAll(Arrays.asList(cityRioBranco, cityMaceio, cityMacapa, cityManaus, citySalvador,
				cityFortaleza, cityVitoria, cityGoiania, citySaoLuis, cityCuiaba, cityCampoGrande, cityBeloHorizonte,
				cityBelem, cityJoaoPessoa, cityCuritiba, cityRecife, cityTeresina, cityRioDeJaneiro, cityNatal,
				cityPortoAlegre, cityPortoVelho, cityBoaVista, cityFlorianopolis, citySaoPaulo, cityAracaju, cityPalmas,
				cityBrasilia));

		Client clientJoao = new Client(null, "João Gabriel Maciel", "joaogcm_jb@outlook.com", "44175228802",
				TypeClient.PHYSICALPERSON);
		clientJoao.getPhones().addAll(Arrays.asList("17996175794"));
		Client clientFlavia = new Client(null, "Flavia Maciel", "flavinhasm_jb@hotmail.com", "88888888888",
				TypeClient.PHYSICALPERSON);
		clientFlavia.getPhones().addAll(Arrays.asList("17991218389"));

		Address addressJoao = new Address(null, "Rua Donato Vissechi", "265", "Apartamento 201", "Centro", "15200000",
				citySaoPaulo, clientJoao);
		Address addressFlavia = new Address(null, "Rua Ademar de Barros", "441", "Não Possui", "Centro", "15200000",
				citySaoPaulo, clientFlavia);

		clientJoao.getAddresses().addAll(Arrays.asList(addressJoao));
		clientFlavia.getAddresses().addAll(Arrays.asList(addressFlavia));

		clientRepository.saveAll(Arrays.asList(clientJoao, clientFlavia));
		addressRepository.saveAll(Arrays.asList(addressJoao, addressFlavia));

		Order orderJoao = new Order(null, simpleDateFormat.parse("16/03/2021 10:58:34"), addressJoao, clientJoao);
		Order orderFlavia = new Order(null, simpleDateFormat.parse("16/03/2021 11:03:23"), addressFlavia, clientFlavia);

		Payment paymentJoao = new PaymentWithCard(null, PaymentStatus.Pending, orderJoao, 2);
		orderJoao.setPaymentOrder(paymentJoao);

		Payment paymentFlavia = new PaymentWithBoleto(null, PaymentStatus.Settled, orderFlavia,
				simpleDateFormat.parse("17/04/2021 23:59:59"), simpleDateFormat.parse("11/04/2021 12:54:55"));
		orderFlavia.setPaymentOrder(paymentFlavia);

		clientJoao.getOrders().addAll(Arrays.asList(orderJoao));
		clientFlavia.getOrders().addAll(Arrays.asList(orderFlavia));

		orderRepository.saveAll(Arrays.asList(orderJoao, orderFlavia));
		paymentRepository.saveAll(Arrays.asList(paymentJoao, paymentFlavia));
	}
}