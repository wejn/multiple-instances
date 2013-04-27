! multiple-instances module
= What's this
This is an example Wowza Media Server module that allows you to load
and configure two (or more) module instances.

See "following blog post"<http://wejn.com/blog/2013/04/on-multiple-wowza-module-instances/> for explanation.

= Installation
Add `wejn-multiple-instances.jar` to Wowza's `lib/` directory.

Add following to Modules section of your Application.xml:
{{{xml
<Module>
    <Name>module1</Name>
    <Description>My awesome Wowza Module (1)</Description>
    <Class>cz.wejn.awesome.Module</Class>
</Module>
<Module>
    <Name>module2</Name>
    <Description>My awesome Wowza Module (2)</Description>
    <Class>cz.wejn.awesome.Module</Class>
</Module>
}}}

Add following to Properties section of your Application.xml:
{{{xml
<Property>
    <Name>module1ImportantProperty</Name>
    <Value>yay</Value>
</Property>
<Property>
    <Name>module2ImportantProperty</Name>
    <Value>yay indeed</Value>
</Property>
}}}

Restart Wowza to finish installation.


= Configuration options
== <moduleName>ImportantProperty
String.

Important property loaded by the module at startup.

= JMX interface
None.

= License
Copyright (c) 2013 Michal "Wejn" Jirku <box@wejn.org>

This work is licensed under the Creative Commons Attribution 3.0 Czech Republic License. To view a copy of this license, visit "http://creativecommons.org/licenses/by/3.0/cz/"<http://creativecommons.org/licenses/by/3.0/cz/>.
