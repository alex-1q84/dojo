#!/usr/bin/env python
#encoding: UTF-8

'''从 pom.xml 文件生成环境配置描述 csv'''

import xml.etree.ElementTree as ET

__author__ = 'bl02515'


props = (
    'id',
    'memcached.servers.url',
    'memcached.servers.port',
    'memcached.servers.backup.url',
    'memcached.servers.backup.port',
    'memcached.enableCache',
    'ximport.mq.producer.url',
    'ximport.mq.producer.edi.url',
    'ximport.mq.listener.master.url',
    'ximport.mq.listener.slave.url',
    'ximport.mq.scanall.concurrentConsumers',
    'ximport.mq.scanall.maxConcurrentConsumers',
    'ximport.mq.listener.taobao.master.url',
    'ximport.mq.listener.taobao.balance.url',
    'ximport.mq.listener.taobao.slave.url',
)


def gen_desc(pom):
    with open(pom) as cfg:
        root = ET.parse(cfg).getroot()
        print ET.dump(root)
        profiles = root.findall("profiles/profile")
        print len(profiles)
        for profile in profiles:
            for prop in props:
                print profile.find(prop).text


if __name__ == '__main__':
    gen_desc(ur'e:\geniexpress\server\trunk\pom.xml')