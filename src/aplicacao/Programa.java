package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Animal;

public class Programa {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Animal ani1 = new Animal(null,"FluFlu","Cachorro");
		// Animal ani2 = new Animal(null,"Balinha","Cachorro");
		// Animal ani3 = new Animal(null,"hajada","Cavalo");
		
		// Estanciando o EntityManagerFactory, com as configura��es que est�o localizada em META-INF/persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lucasJPA");
		
		// Realizando a conex�o com o banco de dados 
		EntityManager em = emf.createEntityManager();
		
		// Iniciando uma transa��o com o Banco de dados
		// em.getTransaction().begin();
		
		// Informa��es a serem inserida
		// em.persist(ani1);
		// em.persist(ani2);
		// em.persist(ani3);
		
		// Confirmar as altera��es
		// em.getTransaction().commit();
		
		
		// Busca um OBJ pelo ID
		 Animal a = em.find(Animal.class, 3);
		 if(a != null) {
		// System.out.println(a);
		
		// Excluindo um OBJ do bando de dados
		/*
		 OBSERVA��ES : Para excluir algum Objeto � recomendando que busque ele antes
			 pois ele estar� em modo de monitoramento, se tenta excluir um objeto com uma conex�o j� fechada, 
			 n�o ser� poss�vel excluir. Sempre que sua opera��o n�o for uma simples consulta, tem que abrir
			 uma trnasa��o, como no caso de ATUALIZAR, DELETAR e ALTERAR;
		 */ 
		 
		// Confirmar as altera��es
		//em.getTransaction().begin();
		
		// Remove o Objeto do banco de dados
		//em.remove(a);
		//System.out.println("Removido com sucesso!");
		
		// Confirmar as altera��es
		//em.getTransaction().commit();
		
		// Iniciando uma transa��o com o Banco de dados
		em.getTransaction().begin();
		
		// Alterar Informa��es do OBJ
		a.setNome("Calvalcante");
		em.persist(a);
		
		// Finalizar Altera��o
		em.getTransaction().commit();
		 }else {
			 System.out.println("Animal n�o existe no Banco de dados");
		 }
		// Finaliza a conex�o
		em.close();
		emf.close();
	}

}
