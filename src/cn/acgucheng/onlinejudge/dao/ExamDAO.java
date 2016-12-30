package cn.acgucheng.onlinejudge.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.acgucheng.onlinejudge.entity.Exam;

/**
 * A data access object (DAO) providing persistence and search support for Exam
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see cn.acgucheng.onlinejudge.entity.Exam
 * @author MyEclipse Persistence Tools
 */
public class ExamDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ExamDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String STATUS = "status";
	public static final String TIME_LIMIT = "timeLimit";

	public void save(Exam transientInstance) {
		log.debug("saving Exam instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Exam persistentInstance) {
		log.debug("deleting Exam instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Exam findById(java.lang.Integer id) {
		log.debug("getting Exam instance with id: " + id);
		try {
			Exam instance = (Exam) getSession().get(
					"cn.acgucheng.onlinejudge.entity.Exam", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Exam instance) {
		log.debug("finding Exam instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.acgucheng.onlinejudge.entity.Exam")
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
		log.debug("finding Exam instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Exam as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByTimeLimit(Object timeLimit) {
		return findByProperty(TIME_LIMIT, timeLimit);
	}

	public List findAll() {
		log.debug("finding all Exam instances");
		try {
			String queryString = "from Exam";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Exam merge(Exam detachedInstance) {
		log.debug("merging Exam instance");
		try {
			Exam result = (Exam) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Exam instance) {
		log.debug("attaching dirty Exam instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Exam instance) {
		log.debug("attaching clean Exam instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}