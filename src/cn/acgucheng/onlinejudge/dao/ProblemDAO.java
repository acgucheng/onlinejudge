package cn.acgucheng.onlinejudge.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.acgucheng.onlinejudge.entity.Problem;

/**
 * A data access object (DAO) providing persistence and search support for
 * Problem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see cn.acgucheng.onlinejudge.entity.Problem
 * @author MyEclipse Persistence Tools
 */
public class ProblemDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ProblemDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String DESCRIPTION = "description";
	public static final String SELECTION = "selection";
	public static final String ANSWER = "answer";

	public void save(Problem transientInstance) {
		log.debug("saving Problem instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Problem persistentInstance) {
		log.debug("deleting Problem instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Problem findById(java.lang.Integer id) {
		log.debug("getting Problem instance with id: " + id);
		try {
			Problem instance = (Problem) getSession().get(
					"cn.acgucheng.onlinejudge.entity.Problem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Problem instance) {
		log.debug("finding Problem instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.acgucheng.onlinejudge.entity.Problem")
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
		log.debug("finding Problem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Problem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findBySelection(Object selection) {
		return findByProperty(SELECTION, selection);
	}

	public List findByAnswer(Object answer) {
		return findByProperty(ANSWER, answer);
	}

	public List findAll() {
		log.debug("finding all Problem instances");
		try {
			String queryString = "from Problem";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Problem merge(Problem detachedInstance) {
		log.debug("merging Problem instance");
		try {
			Problem result = (Problem) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Problem instance) {
		log.debug("attaching dirty Problem instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Problem instance) {
		log.debug("attaching clean Problem instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}