/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portlet.newsreader.model;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.support.PagedListHolder;

/**
 *
 * @author Chris White (christopher.white@manchester.ac.uk)
 */
public class PaginatingNewsFeed extends NewsFeed {

    private static final long serialVersionUID = 1L;

    private final PagedListHolder<NewsFeedItem> holder = new PagedListHolder<NewsFeedItem>();

    public PaginatingNewsFeed(int entriesPerPage) {
        holder.setPage(0);
        holder.setPageSize(entriesPerPage);
        holder.setSource(super.getEntries());
    }

    public PaginatingNewsFeed(int entriesPerPage, int initialPage) {
        holder.setPage(initialPage);
        holder.setPageSize(entriesPerPage);
        holder.setSource(super.getEntries());
    }

    public int getPage() {
        return holder.getPage();
    }

    public void setPage(int p) {
        holder.setPage(p);
    }

    public double getPageCount() {
        return holder.getPageCount();
    }

    @Override
    public List<NewsFeedItem> getEntries() {
        if (holder.getPage() < holder.getPageCount()) {
            return holder.getPageList();
        }
        return Collections.emptyList();
    }
}
