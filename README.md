# 笔记
AckMode
  ~~~~RECORD 				 # 每处理一条commit一次
  BATCH(默认) 			# 每次poll的时候批量提交一次，频率取决于每次poll的调用频率
  TIME 					# 每次间隔ackTime的时间去commit
  COUNT					# 累积达到ackCount次的ack去commit
  COUNT_TIME				# ackTime或ackCount哪个条件先满足，就commit
  MANUAL					# listener负责ack，但是背后也是批量上去
  MANUAL_IMMEDIATE		# listner负责ack，每调用一次，就立即commit

main test1
# 延伸阅读

