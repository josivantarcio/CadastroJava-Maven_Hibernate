package posjavamavenhibernate;

import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

import dao.DaoGeneric;
import model.TelefoneUser;
import model.UsuarioPessoa;

public class TesteHibernate {

	@Test
	public void TestandoHibernateUtil() {

		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<>();

		UsuarioPessoa usuario = new UsuarioPessoa();

		usuario.setNome("logan");
		usuario.setSobrenome("Oliveira");
		usuario.setLogin("pet1");
		usuario.setSenha("gd8g6df66");
		usuario.setEmail("logan@hotmail.com");
		usuario.setNomeMae("pastora alema");
		usuario.setIdade(3);

		daoGeneric.salvar(usuario);
		// HibernateUtil.getEntityManager();
	}

	@Test
	public void TestandoBuscar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(1l);

		pessoa = daoGeneric.pesquisar(pessoa);

		System.out.println(pessoa);
	}

	@Test
	public void TestandoAtualizar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		TelefoneUser telefone = new TelefoneUser();
		pessoa.setId(1l);

		pessoa.setNome("Josevan");
		pessoa.setSobrenome("oliveira");
		pessoa.setIdade(45);
		pessoa.setNomeMae("Vania Maria");
		pessoa.setLogin("josivant");
		pessoa.setEmail("josivatarcio@hotmail.com");
		pessoa.setSenha("fg5w45rg454");

		pessoa = daoGeneric.updateMerge(pessoa);

		JOptionPane.showMessageDialog(null, pessoa);
	}

	@Test
	public void TestandoDeletar() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<>();
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(3l);

		daoGeneric.deletar(pessoa);
		JOptionPane.showMessageDialog(null, "Registro Deletado com Sucesso!");
	}

	@Test
	public void TestandoLista() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<>();

		List<UsuarioPessoa> registros = daoGeneric.pesquisarLista(UsuarioPessoa.class);

		for (UsuarioPessoa usuarioPessoa : registros) {
			System.out.println(usuarioPessoa);
			System.out.println("-----------");
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void TestandoQueryList() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<>();
		List<UsuarioPessoa> registros = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.findAll")
				.getResultList();

		for (UsuarioPessoa usuarioPessoa : registros) {
			System.out.println(usuarioPessoa);
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void TestandoQueryListMaxResult() {
		int n = Integer.valueOf(JOptionPane.showInputDialog("Quantidade de Registros"));
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<>();

		List<UsuarioPessoa> registros = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.listById")
				.setMaxResults(n).getResultList();

		for (UsuarioPessoa usuarioPessoa : registros) {
			System.out.println(usuarioPessoa);
		}
	}

	@Test
	public void TestandoQueryListByName() {
		String name = JOptionPane.showInputDialog("Nome da Pessoa").trim();
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<>();

		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> registros = daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.findAny")
				.setParameter("nome", name).getResultList();

		for (UsuarioPessoa usuarioPessoa : registros) {
			System.out.println(usuarioPessoa);
		}
	}

	@Test
	public void TestandoQueryAddOld() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<>();
		Long addOld = (Long) daoGeneric.getEntityManager().createNamedQuery("UsuarioPessoa.sumYears")
				.getSingleResult();

		System.out.println("Total: " + addOld);
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void TestandoGravarTelefone() {
		@SuppressWarnings("rawtypes")
		DaoGeneric daoGeneric = new DaoGeneric();
		UsuarioPessoa p = new UsuarioPessoa();
		p.setId(5l);
		
		UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(p);
		TelefoneUser tel = new TelefoneUser();
		tel.setNumero("88997900302");
		tel.setTipo("work");
		tel.setUsuarioPessoa(pessoa);
		
		daoGeneric.salvar(tel);
	}
}
