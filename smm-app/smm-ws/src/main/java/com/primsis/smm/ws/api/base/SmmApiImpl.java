package com.primsis.smm.ws.api.base;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primsis.core.base.util.PrimsisWebServiceReponse;
import com.primsis.core.repo.base.CoreApiBase;
import com.primsis.smm.entity.SmmHeaderForm;
import com.primsis.smm.ws.api.SmmApi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/smm")
public class SmmApiImpl extends CoreApiBase implements SmmApi {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5007122085154299722L;

	@Override
	@SuppressWarnings("rawtypes")
	public PrimsisWebServiceReponse loadSmm(SmmHeaderForm requestForm) {
		try {
			log.info("start load smm {} ",requestForm.toString());
			init();
			return null;
		} catch (Exception e) {
			
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public PrimsisWebServiceReponse sendSmm(SmmHeaderForm requestForm) {
		log.info("sendSmm smm {} ",requestForm.toString());
		return null;
	}

	@Override
	public SmmHeaderForm getSmm(SmmHeaderForm requestForm) {
		log.info("sendSmm smm {} ",requestForm.toString());

		return null;
	}

	@Override
	public SmmHeaderForm checkStatusSmm(String uuid) {
		log.info("sendSmm smm {} ",uuid.toString());

		return null;
	}



}
