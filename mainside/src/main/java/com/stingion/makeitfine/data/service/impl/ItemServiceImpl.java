/**
 * Created in scope of "Make it fine" project
 */
package com.stingion.makeitfine.data.service.impl;

import com.stingion.makeitfine.data.model.Item;
import com.stingion.makeitfine.data.service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends EntityServiceImpl<Item> implements ItemService {
}