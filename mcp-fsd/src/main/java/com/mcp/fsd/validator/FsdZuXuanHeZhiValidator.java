package com.mcp.fsd.validator;

import com.mcp.core.util.StringUtil;
import com.mcp.fsd.common.FsdConstants;
import com.mcp.order.exception.CoreException;
import com.mcp.order.exception.ErrCode;

public class FsdZuXuanHeZhiValidator extends FsdValidator {

	@Override
	public int validator(String numbers) throws CoreException {
		if(StringUtil.isEmpty(numbers))
		{
			throw new CoreException(ErrCode.E2026, ErrCode.codeToMsg(ErrCode.E2026));
		}
		if(!numbers.matches("^\\d{1,2}(,\\d{1,2}){0,}$"))
		{
			throw new CoreException(ErrCode.E2033, ErrCode.codeToMsg(ErrCode.E2033));
		}
		String[] numberArray = numbers.split(",");
		int[] num = new int[numberArray.length];
		for(int j = 0; j < num.length; j++)
		{
			num[j] = Integer.parseInt(numberArray[j]);
		}
		super.checkSort(num);
		super.checkMargin(num, FsdConstants.ZUXUAN_HEZHI_MAX, FsdConstants.ZUXUAN_HEZHI_MIN);
		int count = 0;
		for(int j = 0; j < num.length; j++)
		{
			count += FsdConstants.ZUXUAN_HEZHI_COUNT[num[j]];
		}
		return count;
	}

}
