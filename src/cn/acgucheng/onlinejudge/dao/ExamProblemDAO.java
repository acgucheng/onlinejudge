package cn.acgucheng.onlinejudge.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.acgucheng.onlinejudge.entity.Exam;
import cn.acgucheng.onlinejudge.entity.ExamProblem;
import cn.acgucheng.onlinejudge.entity.ExamProblemId;

/**
 * A data access object (DAO) providing persistence and search support for
 * ExamProblem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.acgucheng.onlinejudge.entity.ExamProblem
 * @author MyEclipse Persistence Tools
 */
public class ExamProblemDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ExamProblemDAO.class);
	// property constants
	public static final String VALUE = "value";
	public static final String EXAM = "id.exam";
	public static final String PROBLEMID="id.problem.id";
	public static final String EXAMID="id.exam.id";

	public void save(ExamProblem transientInstance) {
		log.debug("saving ExamProblem instance");
		Transaction trans = getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			getSession().flush();
			getSession().close();
			trans.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			trans.rollback();
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ExamProblem persistentInstance) {
		log.debug("deleting ExamProblem instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ExamProblem findById(cn.acgucheng.onlinejudge.entity.ExamProblemId id) {
		log.debug("getting ExamProblem instance with id: " + id);
		try {
			ExamProblem instance = (ExamProblem) getSession().get(
					"cn.acgucheng.onlinejudge.entity.ExamProblem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ExamProblem instance) {
		log.debug("finding ExamProblem instance by example");
		try {
			List results = getSession()
					.createCriteria("cn.acgucheng.onlinejudge.entity.ExamProblem")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByExamID(Integer examID){
		ExamDAO examDao = new ExamDAO();
		Exam exam = examDao.findById(examID);
		return findByProperty(EXAM,exam);
	}
	
	public List findByProperty(String propertyName, Object value) {
		getSession().clear();
		Transaction trans = getSession().beginTransaction();
		log.debug("finding ExamProblem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ExamProblem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			trans.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			trans.rollback();
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public void deleteByID(Integer examID,Integer problemID){
		
		deleteByProperty(EXAMID,examID,PROBLEMID,problemID);
		
	}
	
	public void deleteByProperty(String propertyName1, Object value1,String propertyName2,Object value2) {
		Transaction trans = getSession().beginTransaction();
		try {
			String queryString = "delete ExamProblem as model where model."
					+ propertyName1 + "= ?" + " and " + propertyName2 + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value1);
			queryObject.setParameter(1, value2);
			queryObject.executeUpdate();
			trans.commit();
		} catch (RuntimeException re) {
			trans.rollback();
			log.error("find by property name failed", re);
			throw re;
		}
	}
	

	public List findByValue(Object value) {
		return findByProperty(VALUE, value);
	}

	public List findAll() {
		log.debug("finding all ExamProblem instances");
		try {
			String queryString = "from ExamProblem";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ExamProblem merge(ExamProblem detachedInstance) {
		log.debug("merging ExamProblem instance");
		try {
			ExamProblem result = (ExamProblem) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ExamProblem instance) {
		log.debug("attaching dirty ExamProblem instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ExamProblem instance) {
		log.debug("attaching clean ExamProblem instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List findByExamIDAndProblemID(Integer examID,Integer problemID) {
		// TODO Auto-generated method stub
		return findByProperty(EXAMID,examID, PROBLEMID,problemID);
	}
	
	public List findByProperty(String propertyName1, Object value1,String propertyName2,Object value2) {
		Transaction trans = getSession().beginTransaction();
		log.debug("finding ExamProblem instance with property: " + propertyName1
				+ ", value: " + value1 + " and " + propertyName2 + "value2");
		try {
			String queryString = "from ExamProblem as model where model."
					+ propertyName1 + "= ?" + " and " + propertyName2 + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			getSession().flush();
			queryObject.setParameter(0, value1);
			queryObject.setParameter(1, value2);
			trans.commit();
			return queryObject.list();
		} catch (RuntimeException re) {
			//trans.rollback();
			log.error("find by property name failed", re);
			throw re;
		}
	}
}