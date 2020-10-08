CREATE TABLE  article  (
   id  bigint(20) NOT NULL AUTO_INCREMENT,
   title  varchar(255) DEFAULT NULL,
   made_date  datetime DEFAULT NULL,
   aproved  bit(1) DEFAULT NULL,
   text  text DEFAULT NULL,
   author  varchar(50) DEFAULT NULL,
   updated datetime DEFAULT NULL,
  PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO vpage.article (title,made_date,aproved,text,author,updated) VALUES 
('teste texto grande',now(),1,'<p>Lorem ipsum dolor sit amet consectetur adipiscing elit ante velit orci, nibh tincidunt turpis scelerisque bibendum enim vestibulum ullamcorper nascetur iaculis, taciti eget blandit mus tempor vitae ultricies aptent eros. Penatibus massa odio eleifend aptent litora parturient vivamus elementum, pharetra duis suspendisse facilisis id viverra cursus at, iaculis fermentum tempor porttitor quisque consequat efficitur. Cubilia porta luctus fames sociosqu sit integer dictumst vulputate velit scelerisque, praesent dignissim lacus augue lacinia facilisi euismod proin consequat suscipit quam, vitae etiam commodo elementum dolor auctor sollicitudin senectus gravida. Efficitur purus et morbi placerat habitasse diam, pharetra vivamus id tristique senectus. Vulputate etiam placerat nam ornare inceptos turpis auctor, aliquet diam cubilia facilisis neque euismod varius, iaculis ultricies pretium in proin ac. Lectus massa tortor taciti aenean penatibus pulvinar finibus curae, erat est ac iaculis inceptos magnis pellentesque viverra, litora consequat leo consectetur nec morbi himenaeos. Morbi ex scelerisque quis curae odio venenatis habitant, molestie et proin aenean dui nostra nunc conubia, etiam inceptos iaculis quisque laoreet sit. Neque dapibus nascetur volutpat luctus urna potenti mollis felis tellus sagittis sociosqu curae sed, enim nec taciti diam lacus platea velit sollicitudin malesuada nullam lorem iaculis.</p>

<p>Efficitur justo morbi sociosqu integer inceptos, praesent pretium augue sit, nulla curae parturient leo. Quisque id dapibus per vivamus placerat non ultrices facilisi magnis, vehicula duis platea facilisis viverra lacus mollis. Integer vehicula tempus cras mus conubia finibus commodo, natoque euismod enim lectus eleifend adipiscing ullamcorper, pretium donec aenean quam senectus sed. Per malesuada pretium neque vitae erat dictumst quisque, dictum mollis senectus aliquam in ut, risus varius velit laoreet justo consectetur. Fames sagittis nunc praesent aptent convallis, quis cursus ante sit. Mi quam auctor elit penatibus ligula himenaeos diam per, dictumst praesent pretium ex nisl tincidunt. Suscipit praesent at sollicitudin ad integer facilisis pulvinar nibh molestie feugiat nullam, turpis porta velit inceptos cursus ipsum duis tempor justo. Dis ligula mollis gravida mattis placerat aptent velit inceptos aenean parturient, auctor nisl habitasse fusce nunc dignissim ac eget tempor fames per, lacus volutpat iaculis nulla venenatis natoque aliquet ullamcorper penatibus. Ultricies turpis adipiscing pharetra fusce ac lorem habitant, pulvinar tincidunt montes facilisi inceptos commodo justo, cras vivamus mi litora velit imperdiet.</p>

<p>Taciti odio inceptos arcu imperdiet ipsum, varius gravida mauris eros, ligula convallis parturient hendrerit. Phasellus nostra orci nascetur sollicitudin molestie rutrum ut lacinia consequat consectetur turpis id magna, morbi quisque primis natoque ipsum praesent ullamcorper curae massa amet lectus. Conubia neque lobortis condimentum elit natoque ornare sed himenaeos eleifend eu platea, ipsum praesent pellentesque aptent sagittis donec vestibulum senectus fermentum dictum curabitur justo, amet ut elementum convallis nullam venenatis vitae in montes lacus. Pharetra sed orci mollis lacus ex auctor bibendum ac iaculis fermentum, inceptos venenatis massa pulvinar amet pretium praesent viverra egestas per proin, risus fringilla integer convallis conubia mi volutpat nulla elementum.</p>
','thor',NULL)
,('mais','2020-08-17 22:19:57.000',1,'sfdsdf','asf',NULL);

