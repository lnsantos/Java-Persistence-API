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
		
		// Estanciando o EntityManagerFactory, com as configurações que estão localizada em META-INF/persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lucasJPA");
		
		// Realizando a conexão com o banco de dados 
		EntityManager em = emf.createEntityManager();
		
		// Iniciando uma transação com o Banco de dados
		// em.getTransaction().begin();
		
		// Informações a serem inserida
		// em.persist(ani1);
		// em.persist(ani2);
		// em.persist(ani3);
		
		// Confirmar as alterações
		// em.getTransaction().commit();
		
		
		// Busca um OBJ pelo ID
		 Animal a = em.find(Animal.class, 3);
		 if(a != null) {
		// System.out.println(a);
		
		// Excluindo um OBJ do bando de dados
		/*
		 OBSERVAÇÕES : Para excluir algum Objeto é recomendando que busque ele antes
			 pois ele estará em modo de monitoramento, se tenta excluir um objeto com uma conexão já fechada, 
			 não será possível excluir. Sempre que sua operação não for uma simples consulta, tem que abrir
			 uma trnasação, como no caso de ATUALIZAR, DELETAR e ALTERAR;
		 */ 
		 
		// Confirmar as alterações
		//em.getTransaction().begin();
		
		// Remove o Objeto do banco de dados
		//em.remove(a);
		//System.out.println("Removido com sucesso!");
		
		// Confirmar as alterações
		//em.getTransaction().commit();
		
		// Iniciando uma transação com o Banco de dados
		em.getTransaction().begin();
		
		// Alterar Informações do OBJ
		a.setNome("Calvalcante");
		em.persist(a);
		
		// Finalizar Alteração
		em.getTransaction().commit();
		 }else {
			 System.out.println("Animal não existe no Banco de dados");
		 }
		// Finaliza a conexão
		em.close();
		emf.close();
	}

}
