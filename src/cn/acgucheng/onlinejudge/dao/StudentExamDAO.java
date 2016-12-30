package cn.acgucheng.onlinejudge.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.acgucheng.onlinejudge.entity.StudentExam;

/**
 * A data access object (DAO) providing persistence and search support for
 * StudentExam entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.acgucheng.onlinejudge.entity.StudentExam
 * @author MyEclipse Persistence Tools
 */
public class StudentExamDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StudentExamDAO.class);
	// property constants
	public static final String SCORE = "score";

	public void save(StudentExam transientInstance) {
		log.debug("saving StudentExam instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(StudentExam persistentInstance) {
		log.debug("deleting StudentExam instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudentExam findById(cn.acgucheng.onlinejudge.entity.StudentExamId id) {
		log.debug("getting StudentExam instance with id: " + id);
		try {
			StudentExam instance = (StudentExam) getSession().get(
					"cn.acgucheng.onlinejudge.entity.StudentExam", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(StudentExam instance) {
		log.debug("finding StudentExam instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.acgucheng.onlinejudge.entity.StudentExam")
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
		log.debug("finding StudentExam instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from StudentExam as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findAll() {
		log.debug("finding all StudentExam instances");
		try {
			String queryString = "from StudentExam";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public StudentExam merge(StudentExam detachedInstance) {
		log.debug("merging StudentExam instance");
		try {
			StudentExam result = (StudentExam) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(StudentExam instance) {
		log.debug("attaching dirty StudentExam instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudentExam instance) {
		log.debug("attaching clean StudentExam instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}