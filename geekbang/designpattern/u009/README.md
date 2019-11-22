# 09-课后思考题

## v1 的问题

1、暴露了 createBucketInfNotExisting、generateAccessToken ，没有必要
2、新增其他ImageStore类型时，需要修改ImageProcessJob类的代码。

## v2 简单工厂方法

问题：新增其他ImageStore类型时，需要修改工厂类ImageStoreFactory

## v3 反射

改进v2
问题：使用反射大量创建对象时，性能会有损失。

具体实现见代码。

2019-11-22