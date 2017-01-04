package cn.acgucheng.onlinejudge.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.acgucheng.onlinejudge.entity.Student;

/**
 * A data access object (DAO) providing persistence and search support for
 * Student entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.acgucheng.onlinejudge.entity.Student
 * @author MyEclipse Persistence Tools
 */
public class StudentDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String NAME = "name";
	public static final String CLASS_ = "class_";
	public static final String PASSWORD = "password";

	public void save(Student transientInstance) {
		log.debug("saving Student instance");
		Transaction tran = getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			getSession().flush();
	        getSession().close();
	        tran.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			tran.rollback();
			throw re;
		}
	}

	public void delete(Student persistentInstance) {
		log.debug("deleting Student instance");
		Transaction trans = getSession().beginTransaction();
		try {
			getSession().delete(persistentInstance);
			trans.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Student findById(java.lang.Integer id) {
		log.debug("getting Student instance with id: " + id);
		try {
			Student instance = (Student) getSession().get(
					"cn.acgucheng.onlinejudge.entity.Student", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Student instance) {
		log.debug("finding Student instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.acgucheng.onlinejudge.entity.Student")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Student instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Student as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByProperty(String propertyName1, Object value1,String propertyName2, Object Value2) {
		log.debug("finding Student instance with property: " + propertyName1
				+ ", value: " + value1);
		try {
			String queryString = "from Student as model where model."
					+ propertyName1 + "= ? and " + propertyName2 + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value1);
			queryObject.setParameter(1, Value2);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsernameAndPassword(Object username,Object password){
		return findByProperty(USERNAME,username,PASSWORD,password);
	}
	
	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByClass_(Object class_) {
		return findByProperty(CLASS_, class_);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findAll() {
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Student merge(Student detachedInstance) {
		log.debug("merging Student instance");
		try {
			Student result = (Student) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Student instance) {
		log.debug("attaching dirty Student instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Student instance) {
		log.debug("attaching clean Student instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}