package com.yixin.study.dao.sharding;

import java.util.Collection;
import java.util.LinkedHashSet;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;
/**
 * 分片策略灵活，可支持=，BETWEEN，IN等多维度分片，也可支持多分片键共用。
 * Package : com.yixin.study.dao.sharding
 * 
 * @author YixinCapital -- zhubing
 *		   2018年4月4日 下午3:46:10
 *
 */
public class DbAlgorithm implements SingleKeyDatabaseShardingAlgorithm<String> {

	/**
	 * 
	 * 
	 * @param availableTargetNames [dataSource_alix, dataSource_ssp]
	 * @param shardingValue        ssp
	 * @return 
	 * @author YixinCapital -- zhubing
	 *	       2018年4月4日 下午2:43:23
	 */
	public String doEqualSharding(Collection<String> availableTargetNames,
			ShardingValue<String> shardingValue) {
		System.out.println("1");
		String address = shardingValue.getValue();
		System.out.println("1.1"+address);
        for (String each : availableTargetNames) {  
            if (each.endsWith(address)) {  
                return each;  
            }  
        }  
        throw new UnsupportedOperationException();  
	}

	/**
	 * 
	 * 
	 * @param availableTargetNames  [dataSource_alix, dataSource_ssp]
	 * @param shardingValue   a,ssp,b
	 * @return 
	 * @author YixinCapital -- zhubing
	 *	       2018年4月4日 下午3:42:21
	 */
	public Collection<String> doInSharding(
			Collection<String> availableTargetNames,
			ShardingValue<String> shardingValue) {
		
		System.out.println("2");
		 Collection<String> result = new LinkedHashSet<String>(availableTargetNames.size());  
	        for (String value : shardingValue.getValues()) {  
	            for (String datasourceName : availableTargetNames) {  
	                if (datasourceName.endsWith(value)) {  
	                    result.add(datasourceName);  
	                }  
	            }  
	        }  
	        return result; 
	}

	/**
	 * 
	 * 
	 * @param availableTargetNames  [dataSource_alix, dataSource_ssp]
	 * @param shardingValue   这个是你Between 1 and 7;range.upperEndpoint()=7;range.lowerEndpoint()=1
	 * @return 
	 * @author YixinCapital -- zhubing
	 *	       2018年4月4日 下午3:32:01
	 */
	public Collection<String> doBetweenSharding(
			Collection<String> availableTargetNames,
			ShardingValue<String> shardingValue) {
		
		System.out.println("3");
		Collection<String> result = new LinkedHashSet<String>(availableTargetNames.size());  
		Range<String> range = (Range<String>) shardingValue.getValueRange();  
		
		String upperEndpoint = range.upperEndpoint();
		String lowerEndpoint = range.lowerEndpoint();
		for (String each : availableTargetNames) {  
            if (each.endsWith(upperEndpoint) || each.endsWith(lowerEndpoint)) {  
                result.add(each);  
            }  
        }    
        return result;
	}

}

