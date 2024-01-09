package com.srm.spring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.srm.spring.dao.CurrentAccountDAO;
import com.srm.spring.dto.CurrentAccountDTO;


@Component
public class CurrentAccountService {
	
	@Autowired
	CurrentAccountDAO currentAccountDAO;

	public CurrentAccountDTO currAccDeposit(CurrentAccountDTO dto) throws Exception{
		
	/*	CurrentAccount curraccobj = new CurrentAccount();
		curraccobj.setCustomerid(dto.getCustomerid());
		curraccobj.setCurraccno(dto.getCurraccno());
		curraccobj.setActiontype(dto.getActiontype());
		curraccobj.setDepositdate(dto.getDepositdate());
		curraccobj.setWithdrawdate(dto.getWithdrawdate());
		curraccobj.setAmount(dto.getAmount());
		CurrentAccount obj = currentAccountDAO.saveCurrentAccount(curraccobj);
		dto.setCurracid(obj.getCurraccid());*/
		return dto;
		
	}

}
