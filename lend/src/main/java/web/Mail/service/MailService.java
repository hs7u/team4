package web.Mail.service;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import web.Mail.dao.MailDao;
@Transactional
//@Service
public class MailService {

//	@Autowired
//	SessionFactory factory;
	
//	@Autowired
	MailDao dao;			
}
